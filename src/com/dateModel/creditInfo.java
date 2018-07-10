package com.dateModel;

public class creditInfo {
	
	private String userName;
	private String RoomId;
	private int creditScore;
	private int creditStage;
	private int creditRank;
	private boolean creditStaus;
	private String debtTime;
	public void setCreditInfo( String userName,String RoomId,int creditScore,int creditStage,int creditRank,boolean creditStaus,String debtTime)
	{
		this.userName = userName;
		this.RoomId = RoomId;
		this.creditScore = creditScore;
		this.creditStage = creditStage;
		this.creditRank = creditRank;
		this.creditStaus = creditStaus;
		this.debtTime = debtTime;
	}
	public void setCreditScore(int score) {
		this.creditScore = score;
	}
	public void setCreditStage(int stage) {
		this.creditStage = stage;
	}
	public void setName(String name) {
		this.userName = name;
	}
	public void setRank(int rank) {
		this.creditRank = rank;
	}
	public void setStatus(boolean status) {
		this.creditStaus = status;
	}
	public int getCreditStage() {
		return this.creditStage;
	}
	public String getName() {
		return this.userName;
	}
	public int getRank() {
		return this.creditRank;
	}
	public boolean getStatus() {
		return this.creditStaus;
	}
	public String getRoomId() {
		return this.RoomId;
	}
	public int getCreditScore() {
		return this.creditScore;
	}
	public String getDebtTime() {
		return this.debtTime;
	}
	
	
}