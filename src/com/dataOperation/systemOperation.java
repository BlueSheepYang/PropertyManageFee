package com.dataOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dateModel.systemInfo;
import com.dateSafe.dateSafe;

public class systemOperation {
	
	dateSafe safe = new dateSafe();
	static final String url = "jdbc:mysql://localhost:3306/managementfeesys";
    //MySQL配置时的用户名
	static final String user = "root";
    //MySQL配置时的密码
	static final String password = "19960917aa";
	private Connection con;
	private Statement statement;
	public systemOperation(){
		try {
		this.con = DriverManager.getConnection(url,user,password);
        if(con.isClosed())
            System.out.println("failed to connect sql!");
        statement = con.createStatement();
		}catch( SQLException e) {
			System.out.println("failed to connecting Mysql");
		}
	}
	public systemInfo findInfo() throws SQLException {
		systemInfo system = new systemInfo();
		Double managementFeePrice;
		int id;
		ResultSet rs;
		String sql = "select * from system;";
		System.out.println(sql);
		rs = statement.executeQuery(sql);
		while(rs.next()){
			managementFeePrice = rs.getDouble("ManagementPrice");
			id = rs.getInt("id");
			system.setFeeModel(id , managementFeePrice);
			return system;
		}
		return system;
	}
	public void modifyPrice(int id , Double price){
		int rs;
		String sql = "update system set ManagementPrice = " + price + " where id=" + id;
		try {
			rs = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sql);
	}

}
