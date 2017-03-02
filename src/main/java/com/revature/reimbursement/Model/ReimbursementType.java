package com.revature.reimbursement.Model;

public class ReimbursementType {
	
	private int rTypeId;
	private String rType;
	
	public ReimbursementType(){}
	public ReimbursementType(int rTypeId, String rType) {
		super();
		this.rTypeId = rTypeId;
		this.rType = rType;
	}
	
	public int getrTypeId() {
		return rTypeId;
	}
	public void setrTypeId(int rTypeId) {
		this.rTypeId = rTypeId;
	}
	public String getrType() {
		return rType;
	}
	public void setrType(String rType) {
		this.rType = rType;
	}
}
