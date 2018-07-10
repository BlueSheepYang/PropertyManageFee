package com.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dataOperation.creditInfoOperation;
import com.dataOperation.houseInfoOperation;
import com.dataOperation.systemOperation;
import com.dataOperation.userInfoOperation;
import com.dateModel.creditInfo;
import com.dateModel.houseInfo;
import com.dateModel.residentInfo;
import com.dateModel.systemInfo;

public class calculateFee {
	
	static final String url = "jdbc:mysql://localhost:3306/managementfeesys";
    //MySQL配置时的用户名
	static final String user = "root";
    //MySQL配置时的密码
	static final String password = "19960917aa";
	private Connection con;
	private Statement statement;
	
	userInfoOperation useroperation = new userInfoOperation();
	houseInfoOperation houseopration = new houseInfoOperation();
	systemOperation systemoperation = new systemOperation();
	creditInfoOperation creditoperation = new creditInfoOperation();
	systemInfo system = new systemInfo();
	residentInfo resident = new residentInfo();
	houseInfo house = new houseInfo();
	creditInfo credit = new creditInfo();
	
	public calculateFee(){
		try {
		this.con = DriverManager.getConnection(url,user,password);
        if(con.isClosed())
            System.out.println("failed to connect sql!");
        statement = con.createStatement();
		}catch( SQLException e) {
			System.out.println("failed to connecting Mysql");
		}
	}
	
	
	public void addFeeAndModifyInfo(String RoomId) { //计算物业费价格，生成，查找居住表中的房间面积信息，并且修改用户表和信用表中相应的信息
		sendMail mail = new sendMail();
		try {
			resident = useroperation.findRoomId(RoomId);
			house = houseopration.findRoomId(RoomId);
			system = systemoperation.findInfo();
			credit = creditoperation.findCreditInfo(RoomId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//生成物业费时，信用表发生变化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date(); 
        Date date2 = new Date();
        try {
			date1 = sdf.parse("2000-01-01 00:00:00");//设定此时间为用户不欠费时间
			date2 = sdf.parse(credit.getDebtTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(date2.equals(date1)) {
			// 当信用表中欠费时间为null时证明当前用户不欠费，所以他最早前费时间就是当前物业费生成时间
			//否则欠费，他的最早欠费时间则不发生变化
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			creditoperation.modifyInfoByDebtTime(RoomId, df.format(new Date()));
		}
		
		
		Double fee = resident.getUserDebt() + system.getFee() * house.getHouseRoomArea();
		useroperation.modifyInfoByDebt(resident.getUserRoomId(), fee); //修改用户表中的欠费金额
		try {
			mail.sendMailToResident(resident.getUserMail());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
