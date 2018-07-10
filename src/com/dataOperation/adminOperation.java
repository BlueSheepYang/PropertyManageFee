package com.dataOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import com.dateModel.adminInfo;
import com.dateModel.creditInfo;
import com.dateModel.residentInfo;
import com.dateSafe.dateSafe;

public class adminOperation {
	systemOperation system = new systemOperation();
	creditInfoOperation creditoperation = new creditInfoOperation();
	houseInfoOperation houseoperation = new houseInfoOperation();
	userInfoOperation useroperation = new userInfoOperation();
	dateSafe safe = new dateSafe();
	static final String url = "jdbc:mysql://localhost:3306/test";
    //MySQL配置时的用户名
	static final String user = "root";
    //MySQL配置时的密码
	static final String password = "19960917aa";
	private Connection con;
	private Statement statement;
	public adminOperation(){
		try {
		this.con = DriverManager.getConnection(url,user,password);
        if(con.isClosed())
            System.out.println("failed to connect sql!");
            statement = con.createStatement();
		}catch( SQLException e) {
			System.out.println("failed to connecting Mysql");
		}
	}
	
	public void addUser(String username,String usesex,String userpwd,String userphone,String usermail,String userroomId) {//添加住户
		ResultSet rs;
		Double userDebt = 0.0;
		int userCreditScore = 70;
		String userName = safe.TransferToAscii(username);
		String useSex = safe.TransferToAscii(usesex);
		String userPwd = safe.TransferToAscii(userpwd);
		String userPhone = safe.TransferToAscii(userphone);
		String userMail = safe.TransferToAscii(usermail);
		String sql = "insert into residentinfo values (" + "\"" + userName + "\"" + ","+ "\"" + useSex + "\"" + ","+ "\"" + userPwd + "\"" + ","+ "\"" + userPhone + "\"" + ","+ "\"" + userMail + "\"" + ","+"\"" + userroomId + "\"" + "," + userDebt + "," + userCreditScore + ");";		
		System.out.println(sql);
		try {
			statement.addBatch(sql);
			statement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		houseoperation.setRoomStatus(userroomId);
		creditoperation.addCreditInfo(username,userroomId);
	}
	
	public void delUser(String roomId) { //删除住户
		useroperation.delByRoomid(roomId);
		houseoperation.setRoomEmptyStatus(roomId);
		creditoperation.delCreditInfo(roomId);
	}
	
	public void modifyAdminInfo(String adminName , String adminPwd,String adminPhone,String adminMail) {
		String sql = "update admininfo set adminPwd = "+ "\"" + adminPwd  +"\"" +","+ "adminPhone = " +"\""+ adminPhone + "\"" +","+ "adminMail = "+ "\""+adminMail + "\"" + " where adminName = " + "\""+adminName+ "\"" ;
		System.out.println(sql);
		int rs = 0;
		try {
			rs = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public residentInfo findByRoomIdUserInfo(String id) { //查找住户基本信息
		residentInfo resident = new residentInfo();
		try {
			resident = useroperation.findRoomId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resident;
	}
	
	public creditInfo findByRoomIdCreditInfo(String id) { //查找住户信用信息
		creditInfo credit = new creditInfo();
		try {
			credit = creditoperation.findCreditInfo(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return credit;
	}
	
//	public void modifyManagementFeePrice(Double price) {
//		try {
//			system.modifyPrice(price);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public boolean findUserAndPwd(String name, String password) throws SQLException {
		ResultSet rs;
		String sql = "select * from admininfo where adminName =" + "\"" + name + "\"" + " and " +"adminPwd =" + "\"" + password + "\"";
		System.out.println(sql);
		rs = statement.executeQuery(sql);
		int count = 0; 
		while (rs.next()) { 
		count = rs.getInt(1); 
		} 
		//System.out.println(rs.);
		if(count==0) {
			return false;
		}
		else {
			return true;
		}
	}
	public adminInfo findAdminInfo(String name) throws SQLException {
		adminInfo admin = new adminInfo();
		ResultSet rs;
		String sql = "select * from admininfo where adminName =" + "\"" + name + "\"";
		rs = statement.executeQuery(sql);
		while(rs.next()){
			int adminId = rs.getInt("adminId");
			String adminName = rs.getString("adminName");
			String adminSex = rs.getString("adminSex");
			String adminPwd = rs.getString("adminPwd");
			String adminPhone = rs.getString("adminPhone");
			String adminMail = rs.getString("adminMail");
			admin.setAdminInfo(adminId, adminName, adminSex, adminPwd, adminPhone, adminMail);
			return admin;
		}
		return admin;
	}
	public Vector<creditInfo> rankCreditScore(){
		
		
		Vector<creditInfo>  credit = new Vector();
		Vector<creditInfo>  Newcredit = new Vector();
		int j = 0;
		try {
			credit = creditoperation.findCreditInfo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(credit.size()>1) {
			j=0;
			int min = credit.get(0).getCreditScore();
			for(int i=0;i<credit.size();i++) 
			{
				if(min>credit.get(i).getCreditScore());
				j=i;
			}
			Newcredit.add(credit.get(j));
			credit.remove(j);
		}
		Newcredit.add(credit.get(0));
		return Newcredit;
	}
	public Vector<residentInfo> rankDebt(){
		Vector<residentInfo> allUser = new Vector();
		Vector<residentInfo> newAllUser = new Vector();
		int j=0;
		try {
			allUser = useroperation.findAllUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(allUser.size()>1) {
			j=0;
			Double min = allUser.get(0).getUserDebt();
			for(int i=0;i<allUser.size();i++) 
			{
				if(min<allUser.get(i).getUserDebt())
				{
					j=i;
				}
			}
			newAllUser.add(allUser.get(j));
			allUser.remove(j);
		}
		newAllUser.add(allUser.get(0));
		return newAllUser;
	}
	public Vector<creditInfo> rankDebtTime() throws ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		java.util.Date dt1;
		java.util.Date dt2;
		
		Vector<creditInfo>  credit = new Vector();
		Vector<creditInfo>  Newcredit = new Vector();
		int j = 0;
		try {
			credit = creditoperation.findCreditInfo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(credit.size()>1) {
			j=0;
			dt1 = df.parse(credit.get(0).getDebtTime());
			for(int i=0;i<credit.size();i++) 
			{
				if(dt1.getTime()>df.parse(credit.get(i).getDebtTime()).getTime());
				j=i;
			}
			Newcredit.add(credit.get(j));
			credit.remove(j);
		}
		Newcredit.add(credit.get(0));
		return Newcredit;
	}

}
