package com.dateModel;

public class houseInfo {
	
	private String houseId;
	private String houseUnit;
	private String houseFloor;
	private String houseRoomId;
	private Double houseRoomArea;
	private int houseEmptyOrNot;
	
	public void setHouseInfo(String houseId,String houseUnit,String houseFloor,String houseRoomId,Double houseRoomArea, int houseEmptyOrNot) {
		this.houseId = houseId;
		this.houseUnit = houseUnit;
		this.houseFloor = houseFloor;
		this.houseRoomId = houseRoomId;
		this.houseRoomArea = houseRoomArea;
		this.houseEmptyOrNot = houseEmptyOrNot;
	}
	
	public String getHouseId() {
		return this.houseId;
	}
	public String getHouseUnit() {
		return this.houseUnit;
	}
	public String getHouseFloor() {
		return this.houseFloor;
	}
	public String getHouseRoomId() {
		return this.houseRoomId;
	}
	public Double getHouseRoomArea() {
		return this.houseRoomArea;
	}
	public int getHouseEmptyOrNot() {
		return this.houseEmptyOrNot;
	}

}
