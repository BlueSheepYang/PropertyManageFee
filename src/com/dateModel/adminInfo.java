package com.dateModel;

public class adminInfo {
	
	private int adminId;					//编号
	private String adminName;				//姓名
	private String adminPwd;				//密码
	private String adminSex;				//性别;男：1,女：0
	private String adminPhone;				//电话号码
	private String adminMail;				//邮箱
	
	public adminInfo() {}
	
	public void setAdminInfo(int id, String name, String sex, String pwd,String phone, String mail) {
		this.adminId = id;
		this.adminName = name;
		this.adminPwd = pwd;
		this.adminSex = sex;
		this.adminPhone = phone;
		this.adminMail = mail;
	}
	
	public int getAdminID() {
		//获取姓名
		return adminId;
	}
	
	public void setAdminNo(int id) {
		//设置姓名
		this.adminId = id;
	}
	
	public String getAdminName() {
		//获取姓名
		return adminName;
	}
	
	public void setAdminName(String name) {
		//设置姓名
		this.adminName = name;
	}
	
	public String getAdminPWD() {
		//获取密码
		return adminPwd;
	}
	
	public void setAdminPWD(String Pwd) {
		//设置密码
		this.adminPwd = Pwd;
	}
	
	public String getAdminSex() {
		//获取性别
		return adminSex;
	}	

	public void setAdminSex(String sex) {
		//设置性别
		this.adminSex = sex;
	}
	
	public String getAdminPhone() {
		//获取电话
		return adminPhone;
	}
	
	public void setAdminPhone(String phone) {
		//设置电话
		this.adminPhone = phone;
	}
	
	
	public String getAdminMail(){
		//获取邮箱
		return adminMail;
	}
	
	public void setAdminMail(String mail){
		//设置邮箱
		this.adminMail = mail;
	}

}
