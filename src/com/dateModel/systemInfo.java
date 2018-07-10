package com.dateModel;

public class systemInfo {
	
	private Double fee;
	private int id;
	
	public void setFeeModel(int id,Double fee) {
		this.id = id;
		this.fee = fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Double getFee() {
		return this.fee;
	}
	
	public int getId() {
		return this.id;
	}

}