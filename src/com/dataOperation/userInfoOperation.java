package com.dataOperation;
import com.dateModel.residentInfo;
import com.dateSafe.dateSafe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class userInfoOperation {
	dateSafe safe = new dateSafe();
	static final String url = "jdbc:mysql://localhost:3306/managementfeesys";
    //MySQL配置时的用户名
	static final String user = "root";
    //MySQL配置时的密码
	static final String password = "19960917aa";
	private Connection con;
	private Statement statement;
	public userInfoOperation(){
		try {
		this.con = DriverManager.getConnection(url,user,password);
        if(con.isClosed())
            System.out.println("failed to connect sql!");
        statement = con.createStatement();
		}catch( SQLException e) {
			System.out.println("failed to connecting Mysql");
		}
	}
	public boolean insertFunction(residentInfo resident){
		try {
			System.out.println(resident.getUserName());
			String name = resident.getUserName();
			String sex = resident.getUserSex();
			String password = resident.getUserPwd();
			String phone = resident.getUserPhone();
			String mail = resident.getUserMail();
			String roomId = resident.getUserRoomId();
			double debt = resident.getUserDebt();
			int score = resident.getUserEditScore();
			name = safe.TransferToAscii(name);
			sex = safe.TransferToAscii(sex);
			password = safe.TransferToAscii(password);
			phone = safe.TransferToAscii(phone);
			mail = safe.TransferToAscii(mail);
			String sql = "insert into residentinfo values(" + "\"" + name + "\"" + ","+ "\"" +sex + "\""+ "," + "\""+ password + "\""+ ","+ "\"" + phone + "\""+ "," + "\""+mail+ "\""+ "," + "\""+ roomId+ "\""+"," + debt + "," + score +")";	
			System.out.println(sql);
			statement.addBatch(sql);
		}catch (SQLException e){
			return false;
		}
			return true;
             
	}
	public void delByRoomid(String roomId) {
		ResultSet rs;
		String sql = "delete from residentinfo where userRoomId = " + roomId;		
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet selectFunction() throws SQLException {
		ResultSet rs;
		String sql = "select * from residentinfo";		
		rs = statement.executeQuery(sql);
		return rs;			
	}
	public ResultSet selectFromName(String name) throws SQLException{
		ResultSet rs;
		String sql = "select * from residentinfo where userName = "+name;		
		rs = statement.executeQuery(sql);
		return rs;		
	}
	public ResultSet selectFromUnit(int unit) throws SQLException{
		ResultSet rs;
		String sql = "select * from residentinfo where userUnit ='" + unit + "' ";		
		rs = statement.executeQuery(sql);
		return rs;		
	}
	public boolean findUserAndPwd(String name, String password ,String roomId) throws SQLException {
		ResultSet rs;
		String sql = "select * from residentinfo where userName =" + "\"" + name + "\"" + " and " +"userPwd =" + "\"" + password + "\" "+ "and " +"userRoomId =" + "\"" + roomId + "\" ;";
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
	public residentInfo findRoomId(String roomid) throws SQLException{
		ResultSet rs;
		String userName,userSex,userPwd,userPhone,userMail,userRoomId;
		Double userDebt;
		int userEditScore;
		residentInfo user = new residentInfo();
		String sql = "select * from residentinfo where userRoomId =" + "\"" + roomid + "\" ;";
		System.out.println(sql);
		rs = statement.executeQuery(sql);
		while(rs.next()){
			userName = rs.getString("userName");
			String UserName = safe.TransferToString(userName);
			userSex = rs.getString("useSex");
			String UserSex = safe.TransferToString(userSex);
			userPwd = rs.getString("userPwd");
			String UserPwd = safe.TransferToString(userPwd);
			userPhone = rs.getString("userPhone");
			String UserPhone = safe.TransferToString(userPhone);
			userMail = rs.getString("userMail");
			String UserMail = safe.TransferToString(userMail);
			userRoomId = rs.getString("userRoomId");
			userDebt = rs.getDouble("userDebt");
			userEditScore = rs.getInt("userCreditScore");
			System.out.println(UserPhone);
			user.setUserInfo(UserName,UserSex,UserPwd,UserPhone,UserMail,userRoomId,userDebt,userEditScore);
			return user;
		}
		return user;
	}
	public boolean modifyInfo(String number , String name,String password,String phone,String mail){
		String Name = safe.TransferToAscii(name);
		String Password = safe.TransferToAscii(password);
		String Phone = safe.TransferToAscii(phone);
		String Mail = safe.TransferToAscii(mail);
		String sql = "update residentinfo set userName = "+ "\"" + Name  +"\"" +","+ "userPwd = " +"\""+ Password + "\"" +","+ "userPhone = "+ "\""+Phone + "\"" + ","+"userMail = " +"\""+Mail+"\"" + "where userRoomId = " + number ;
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
	public boolean modifyInfoByDebt(String number ,Double debt){
		String sql = "update residentinfo set userDebt = "+ "\"" + debt  +"\"" + "where userRoomId = " + number ;
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
	
	
	public boolean modifyInfoCredit(String number,int score) {
		String sql = "update residentinfo set userCreditScore = "+ "\"" + score  +"\"" + "where userRoomId = " + number ;
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
	
	public Vector findAllRoomId() throws SQLException{
		
		Vector RoomIdList = new Vector();
		String roomId;
		String sql = "select * from residentinfo";
		ResultSet rs;
		rs = statement.executeQuery(sql);
		while(rs.next()){
			roomId = rs.getString("userRoomId");
			RoomIdList.add(roomId);
		}
		return RoomIdList;
	}
	public Vector<residentInfo> findAllUser() throws SQLException{
		Vector<residentInfo> alluser = new Vector();
		ResultSet rs;
		String userName,userSex,userPwd,userPhone,userMail,userRoomId;
		Double userDebt;
		int userEditScore;
		String sql = "select * from residentinfo";
		System.out.println(sql);
		rs = statement.executeQuery(sql);
		while(rs.next()){
			residentInfo user = new residentInfo();
			userName = rs.getString("userName");
			String UserName = safe.TransferToString(userName);
			userSex = rs.getString("useSex");
			String UserSex = safe.TransferToString(userSex);
			userPwd = rs.getString("userPwd");
			String UserPwd = safe.TransferToString(userPwd);
			userPhone = rs.getString("userPhone");
			String UserPhone = safe.TransferToString(userPhone);
			userMail = rs.getString("userMail");
			String UserMail = safe.TransferToString(userMail);
			userRoomId = rs.getString("userRoomId");
			userDebt = rs.getDouble("userDebt");
			userEditScore = rs.getInt("userCreditScore");
			System.out.println(UserPhone);
			user.setUserInfo(UserName,UserSex,UserPwd,UserPhone,UserMail,userRoomId,userDebt,userEditScore);
			alluser.add(user);
		}
		return alluser;
	}
}
