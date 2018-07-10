package com.dataOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dateModel.paymentListInfo;
import com.dateModel.residentInfo;
import com.dateSafe.dateSafe;

public class paymentListOperation {
	static final String url = "jdbc:mysql://localhost:3306/managementfeesys";
    //MySQL配置时的用户名
	static final String user = "root";
    //MySQL配置时的密码
	static final String password = "19960917aa";
	private Connection con;
	private Statement statement;
	public paymentListOperation(){
		try {
		this.con = DriverManager.getConnection(url,user,password);
        if(con.isClosed())
            System.out.println("failed to connect sql!");
        statement = con.createStatement();
		}catch( SQLException e) {
			System.out.println("failed to connecting Mysql");
		}
	}
	
	public boolean insertFunction(paymentListInfo paymentInfo){
		try {
			String name = paymentInfo.getName();
			Double Amount = paymentInfo.getAmount();
			String PayFeeTime = paymentInfo.getPaymentTime();
			Double debtFee = paymentInfo.getDebtFee();
			String roomId = paymentInfo.getRoomId();
			String sql = "insert into pricelist(userName,PayFeeTime,amount,debtFee,roomId) values(" + "\"" +name + "\"" + "," + "\"" + PayFeeTime + "\"" + "," + Amount + "," + debtFee + "," + "\"" + roomId + "\"" + ");";	
			System.out.println(sql);
			statement.executeUpdate(sql);
		}catch (SQLException e){
			return false;
		}
			return true;
             
	}
	public ResultSet findRoomId(String roomid) throws SQLException{
		ResultSet rs;
		String sql = "select * from pricelist where roomId =" + "\"" + roomid + "\" ;";
		System.out.println(sql);
		rs = statement.executeQuery(sql);
		return rs;
	}
}
