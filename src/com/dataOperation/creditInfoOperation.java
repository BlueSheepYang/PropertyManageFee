package com.dataOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import com.dateModel.*;
import com.dateSafe.dateSafe;

public class creditInfoOperation {
	dateSafe safe = new dateSafe();
	static final String url = "jdbc:mysql://localhost:3306/managementfeesys";
    //MySQL配置时的用户名
	static final String user = "root";
    //MySQL配置时的密码
	static final String password = "19960917aa";
	private Connection con;
	private Statement statement;
	public creditInfoOperation(){
		try {
		this.con = DriverManager.getConnection(url,user,password);
        if(con.isClosed())
            System.out.println("failed to connect sql!");
        statement = con.createStatement();
		}catch( SQLException e) {
			System.out.println("failed to connecting Mysql");
		}
	}
	public Vector<creditInfo> findCreditInfo() throws SQLException{
		
		Vector allSample = new Vector();
		ResultSet rs;

		int creditScore;
		int creditRank;
		String roomId;
		String userName;
		int creditStage;
		boolean creditStaus;
		String debtTime;
		String sql = "select * from credittable";
		rs = statement.executeQuery(sql);
		while(rs.next()){
			creditInfo credit = new creditInfo();
			userName = rs.getString("userName");
			roomId = rs.getString("userRoomId");
			creditScore = rs.getInt("userCreditScore");
			creditRank = rs.getInt("userCreditRank");
			creditStage = rs.getInt("userCreditStage");
			creditStaus = rs.getBoolean("userCreditStatus");
			debtTime = rs.getString("userDebtTime");
			credit.setCreditInfo(userName, roomId, creditScore, creditStage, creditRank, creditStaus, debtTime);
			allSample.add(credit);
		}
		return allSample;
	}
	
	public creditInfo findCreditInfo(String Roomid) throws SQLException {
		creditInfo credit = new creditInfo();
		ResultSet rs;
		String userName;
		String RoomId;
		int creditScore;
		int creditStage;
		int creditRank;
		boolean creditStaus;
		String debtTime;
		String sql = "select * from credittable where userRoomId =" + "\"" + Roomid + "\" ;";
		System.out.println(sql);
		System.out.println(sql);
		rs = statement.executeQuery(sql);
		while(rs.next()){
			userName = rs.getString("userName");
			RoomId = rs.getString("userRoomId");
			creditScore = rs.getInt("userCreditScore");
			creditStage = rs.getInt("userCreditStage");
			creditRank = rs.getInt("userCreditRank");
			creditStaus = rs.getBoolean("userCreditStatus");
			debtTime = rs.getString("userDebtTime");
			credit.setCreditInfo(userName, RoomId, creditScore, creditStage, creditRank, creditStaus,debtTime);
			return credit;
		}
		return credit;
	}
	
	public boolean modifyInfoByDebtTime(String number ,String time){
		String sql = "update credittable set userDebtTime = "+ "\"" + time  +"\"" + "where userRoomId = " + number ;
		System.out.println(sql);
		int rs = 0;
		try {
			rs = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs>0)
			return true;
		else
			return false;
	}
	
	public boolean modifyCreditRank(String roomId,int rankNum) {
		String sql = "update credittable set userCreditRank = "+ "\"" + rankNum  +"\"" + "where userRoomId = " + roomId ;
		System.out.println(sql);
		int rs = 0;
		try {
			rs = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs>0)
			return true;
		else
			return false;
	}
	
	public boolean modifyCreditStatus(String roomId,String CreditStatus) {
		String sql = "update credittable set userCreditStatus = "+ "\"" + CreditStatus + "\"" + "where userRoomId = " + roomId ;
		System.out.println(sql);
		int rs = 0;
		try {
			rs = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs>0)
			return true;
		else
			return false;
	}
	public boolean modifyCreditStage(String roomId,int CreditStage) {
		String sql = "update credittable set userCreditStatus = "+ "\"" + CreditStage + "\"" + "where userRoomId = " + roomId ;
		System.out.println(sql);
		int rs = 0;
		try {
			rs = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs>0)
			return true;
		else
			return false;
	}
	public boolean modifyCreditScore(String roomId,int CreditScore) {
		String sql = "update credittable set userCreditScore = "+ "\"" + CreditScore + "\"" + "where userRoomId = " + roomId ;
		System.out.println(sql);
		int rs = 0;
		try {
			rs = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs>0)
			return true;
		else
			return false;
	}
	public boolean modifyDebtTime(String roomId,String date) {
		String sql = "update credittable set userDebtTime = "+ "\"" + date + "\"" + "where userRoomId = " + roomId ;
		System.out.println(sql);
		int rs = 0;
		try {
			rs = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs>0)
			return true;
		else
			return false;
	}
	
	public void addCreditInfo(String userName,String userRoomId) {

		String date1 = "2000-01-01 00:00:00";
		int userCreditScore = 70;
		int userCreditRank = 1;
		int userCreditStage = 1;
		int userCreditStatus = 0;

		String sql = "insert into credittable values(" + "\"" + userName + "\"" + ","+ "\"" +userRoomId + "\""+ "," + userCreditScore + "," + userCreditRank + "," + userCreditStage + "," + userCreditStatus + "," +"\"" + date1 + "\"" +")";	
		System.out.println(sql);
		try {
			statement.addBatch(sql);
			statement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delCreditInfo(String userRoomId) {

		ResultSet rs;

		String sql = "delete from credittable where userRoomId = " + userRoomId;	
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
