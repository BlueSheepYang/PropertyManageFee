package com.dateModel;

public class paymentListInfo {
	
	private int itemId;
	private String userName;
	private String paymentTime;
	private Double amount;
	private String roomId;
	private Double debtFee;
	
	public void setPaymentInfo(String userName,String paymentTime,Double amount,String RoomId,Double debtFee) {
		this.userName = userName;
		this.paymentTime = paymentTime;
		this.amount = amount;
		this.roomId = RoomId;
		this.debtFee = debtFee;
	}
	public String getName() {
		return this.userName;
	}
	public String getPaymentTime() {
		return this.paymentTime;
	}
	public Double getAmount() {
		return this.amount;
	}
	public String getRoomId() {
		return this.roomId;
	}
	public Double getDebtFee() {
		return this.debtFee;
	}
	public void setName(String name) {
		this.userName = name;
	}
	public void setPaymentTime(String paymentTime) {
		this.paymentTime = paymentTime;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public void setDebtFee(Double debtFee) {
		this.debtFee = debtFee;
	}

}
