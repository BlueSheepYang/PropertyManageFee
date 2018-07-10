package com.system;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import com.dataOperation.creditInfoOperation;
import com.dataOperation.houseInfoOperation;
import com.dataOperation.systemOperation;
import com.dataOperation.userInfoOperation;
import com.dateModel.creditInfo;
import com.dateModel.houseInfo;
import com.dateModel.residentInfo;
import com.dateModel.systemInfo;

public class maintainCredit {
	
	userInfoOperation useroperation = new userInfoOperation();
	houseInfoOperation houseopration = new houseInfoOperation();
	systemOperation systemoperation = new systemOperation();
	creditInfoOperation creditoperation = new creditInfoOperation();
	systemInfo system = new systemInfo();
	residentInfo resident = new residentInfo();
	houseInfo house = new houseInfo();
	creditInfo credit = new creditInfo();
	
	public void creditScoreAdd(String RoomId) { //按时缴费添加十分的信用得分,五天之内缴清
		int creditScore;
		try {
			credit = creditoperation.findCreditInfo(RoomId);
			resident = useroperation.findRoomId(RoomId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(resident.getUserDebt()==0) {//如果欠费为零在进行判断
			creditScore = credit.getCreditScore();
			String date1 = credit.getDebtTime();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String date2 = df.format(new Date());
			long days = calculateDate(date1,date2);
			if(days<=5) {
				creditScore = creditScore + 10;
				creditoperation.modifyCreditScore(RoomId,creditScore);
				useroperation.modifyInfoCredit(RoomId,creditScore);
			}
		}
	}
	
	public void creditScoreMinus(String RoomId) { 
	     //每天确定一个时间运行一次，如果用户信用表有欠费日期，且与当前日期大于5天则扣分
		int creditScore;
		try {
			credit = creditoperation.findCreditInfo(RoomId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		creditScore = credit.getCreditScore();
		String date1 = credit.getDebtTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date2 = df.format(new Date());
		long days = calculateDate(date1,date1);
		if(days>5) {
			creditScore = creditScore - 2;
			creditoperation.modifyCreditScore(RoomId,creditScore);
			useroperation.modifyInfoCredit(RoomId,creditScore);
		}
		
	}
	
	public void updateDaily() { //每天需进行更新的内容
		//分数排名
		//分数
		//扣分状态
		//信用等级
	}
	
	public void modifyUserCreditStatus(String roomId) { //扣分状态：缴费缴纳清后应进行判断；每天检查进行判断
		
		residentInfo user = new residentInfo();
		creditInfo credit = new creditInfo();
		String flag = "0";
		try {
			user = useroperation.findRoomId(roomId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user.getUserDebt() == 0) {
			creditoperation.modifyCreditStatus(roomId, flag);
		}
		
	}
	
	public void modifyUserCreditStage(String roomId) { // 可放在上面两个加减分函数中 更新当前信用情况：优秀 良好 有待提高，两种情况：每天更新超过时间未缴费可能会变化；缴纳费用加分时也可能会变化
		residentInfo user = new residentInfo();
		creditInfo credit = new creditInfo();
		int creditStage;
		try {
			credit = creditoperation.findCreditInfo(roomId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(credit.getCreditScore()>100) {
			creditStage = 4;
		}
		else if(credit.getCreditScore()>70&&credit.getCreditScore()<=100) {
			creditStage = 3;
		}
		else if(credit.getCreditScore()>50&&credit.getCreditScore()<=80) {
			creditStage = 2;
		}
		else {
			creditStage = 1;
		}
		creditoperation.modifyCreditStage(roomId,creditStage);
	}
	
	public void updateUserCreditRank() {//更新信用分数排名
		String roomid;
		int rankNum = 1;
		int nowRank = 0;
		Vector <creditInfo>allSample = new Vector();
		creditInfo Sample = new creditInfo();
		try {
			allSample = creditoperation.findCreditInfo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<allSample.size() ;i++) { //取出对象的信用分数属性
			Sample = allSample.get(i);
			nowRank = Sample.getCreditScore();
			System.out.println(nowRank);
			for(int j=0;j<allSample.size() ;j++) { //一个一个进行遍历比较
				Sample = allSample.get(j);
				if(Sample.getCreditScore() > nowRank) { //如果大于，则排名加一
					System.out.println(Sample.getCreditScore());
					rankNum++;
				}
			}
			creditoperation.modifyCreditRank(allSample.get(i).getRoomId(), rankNum);//更新排名操作
			rankNum = 1;
		}
	}
	public long calculateDate(String dateOne,String dateTwo) { //日期差计算
		Date date1 = new Date();  
		Date date2 = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        try {
        	date1 = sdf.parse(dateOne);
			date2 = sdf.parse(dateTwo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        long days = (date2.getTime() - date1.getTime()) / (24*3600*1000);  
        return days;
	}
	public void modifyDebtTime(String RoomId) {
		String date = "2000-01-01";
		try {
			credit = creditoperation.findCreditInfo(RoomId);
			resident = useroperation.findRoomId(RoomId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(resident.getUserDebt()==0) {//如果欠费为零在进行修改最远欠费时间
			creditoperation.modifyDebtTime(RoomId, date);
		}
	}
	

}
