package com.revature.reimbursement.Model;

public class ReimbursementStatus {

	private int rStatusId;
	private String rStatus;
	
	public ReimbursementStatus(){}
	public ReimbursementStatus(int rStatusId, String rStatus) {
		super();
		this.rStatusId = rStatusId;
		this.rStatus = rStatus;
	}
	
	public int getrStatusId() {
		return rStatusId;
	}
	public void setrStatusId(int rStatusId) {
		this.rStatusId = rStatusId;
	}
	public String getrStatus() {
		return rStatus;
	}
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}	
}
