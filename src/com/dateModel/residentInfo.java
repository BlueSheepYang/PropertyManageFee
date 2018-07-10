package com.dateModel;
import com.dateSafe.*;

public class residentInfo {
	
	private String userName;
	private String userSex;
	private String userPwd;
	private String userPhone;
	private String userMail;
	private String userRoomId;
	private Double userDebt;
	private int userEditScore;
	
	dateSafe safe = new dateSafe();
	
	public void setUserInfo(String userName,String userSex,String userPwd,String userPhone, String userMail,String userRoomId,double userDebt,int userEditScore) {
		this.userName = userName;
		this.userSex = userSex;
		this.userPwd = userPwd;
		this.userPhone = userPhone;
		this.userMail = userMail;
		this.userRoomId = userRoomId;
		this.userDebt = userDebt;
		this.userEditScore = userEditScore;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public void setUserRoomId(String userRoomId) {
		this.userRoomId = userRoomId;
	}

	public void setUserDebt(Double userDebt) {
		this.userDebt = userDebt;
	}
	public void setUserEditScore(int userEditScore) {
		this.userEditScore = userEditScore;
	}
	
	public String getUserName() {
		return userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public String getUserMail() {
		return userMail;
	}
	public String getUserRoomId() {
		return userRoomId;
	}
	public Double getUserDebt() {
		return userDebt;
	}
	public int getUserEditScore() {
		return userEditScore;
	}
	
}
