package com.dataOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.dateModel.houseInfo;
import com.dateModel.residentInfo;
import com.dateSafe.dateSafe;

public class houseInfoOperation {
	
	dateSafe safe = new dateSafe();
	static final String url = "jdbc:mysql://localhost:3306/managementfeesys";
    //MySQL配置时的用户名
	static final String user = "root";
    //MySQL配置时的密码
	static final String password = "19960917aa";
	private Connection con;
	private Statement statement;
	public houseInfoOperation(){
		try {
		this.con = DriverManager.getConnection(url,user,password);
        if(con.isClosed())
            System.out.println("failed to connect sql!");
        statement = con.createStatement();
		}catch( SQLException e) {
			System.out.println("failed to connecting Mysql");
		}
	}
	
	public houseInfo findRoomId(String roomid) throws SQLException{
		houseInfo house = new houseInfo();
		ResultSet rs;
		String houseId, houseUnit, houseFloor, houseRoomId;
		Double houseRoomArea;
		int houseEmptyOrNot;
		String sql = "select * from houseinfo where houseId =" + "\"" + roomid + "\" ;";
		System.out.println(sql);
		rs = statement.executeQuery(sql);
		while(rs.next()){
			houseId = rs.getString("houseId");
			houseUnit = rs.getString("houseUnit");
			houseFloor = rs.getString("houseFloor");
			houseRoomId = rs.getString("houseRoomId");
			houseRoomArea = rs.getDouble("houseRoomArea");
			houseEmptyOrNot = rs.getInt("houseEmptyOrNot");
			house.setHouseInfo(houseId, houseUnit, houseFloor, houseRoomId, houseRoomArea, houseEmptyOrNot);
			return house;
		}
		return house;
	}
	public Vector<houseInfo> findRoomStatus() throws SQLException{
		
		Vector houseList = new Vector();
		ResultSet rs;
		String houseId, houseUnit, houseFloor, houseRoomId;
		Double houseRoomArea;
		int houseEmptyOrNot;
		String sql = "select * from houseinfo";
		System.out.println(sql);
		rs = statement.executeQuery(sql);
		while(rs.next()){
			houseInfo house = new houseInfo();
			houseId = rs.getString("houseId");
			houseUnit = rs.getString("houseUnit");
			houseFloor = rs.getString("houseFloor");
			houseRoomId = rs.getString("houseRoomId");
			houseRoomArea = rs.getDouble("houseRoomArea");
			houseEmptyOrNot = rs.getInt("houseEmptyOrNot");
			house.setHouseInfo(houseId, houseUnit, houseFloor, houseRoomId, houseRoomArea, houseEmptyOrNot);
			houseList.add(house);
		}
		return houseList;
	}
	
	public void setRoomStatus(String roomId) {
		boolean flag = false;
		String sql = "update houseinfo set houseEmptyOrNot = "+ "\"" + "0" + "\"" + "where houseId = " + roomId ;
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setRoomEmptyStatus(String roomId) {
		String flag = "1";
		String sql = "update houseinfo set houseEmptyOrNot = "+ "\"" + "1" + "\"" + "where houseId = " + roomId ;
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
