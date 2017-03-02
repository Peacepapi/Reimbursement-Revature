package com.revature.reimbursement.Model;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
	
	private int rId;
	private double rAmount;
	private Timestamp rSubmitted;
	private Timestamp rResolved;
	private String rDescription;
	private Blob rReceipt;
	private ReimbursementStatus rStatus;
	private ReimbursementType rType;
	private User rAuthor;
	private User rResolver;
	
	public Reimbursement() {}
	public Reimbursement(int rId, double rAmount, Timestamp rSubmitted, Timestamp rResolved, String rDescription,
			Blob rReceipt, ReimbursementStatus rStatus, ReimbursementType rType, User rAuthor, User rResolver) {
		super();
		this.rId = rId;
		this.rAmount = rAmount;
		this.rSubmitted = rSubmitted;
		this.rResolved = rResolved;
		this.rDescription = rDescription;
		this.rReceipt = rReceipt;
		this.rStatus = rStatus;
		this.rType = rType;
		this.rAuthor = rAuthor;
		this.rResolver = rResolver;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public double getrAmount() {
		return rAmount;
	}
	public void setrAmount(double rAmount) {
		this.rAmount = rAmount;
	}
	public Timestamp getrSubmitted() {
		return rSubmitted;
	}
	public void setrSubmitted(Timestamp rSubmitted) {
		this.rSubmitted = rSubmitted;
	}
	public Timestamp getrResolved() {
		return rResolved;
	}
	public void setrResolved(Timestamp rResolved) {
		this.rResolved = rResolved;
	}
	public String getrDescription() {
		return rDescription;
	}
	public void setrDescription(String rDescription) {
		this.rDescription = rDescription;
	}
	public Blob getrReceipt() {
		return rReceipt;
	}
	public void setrReceipt(Blob rReceipt) {
		this.rReceipt = rReceipt;
	}
	public ReimbursementStatus getrStatus() {
		return rStatus;
	}
	public void setrStatus(ReimbursementStatus rStatus) {
		this.rStatus = rStatus;
	}
	public User getrAuthor() {
		return rAuthor;
	}
	public void setrAuthor(User rAuthor) {
		this.rAuthor = rAuthor;
	}
	public User getrResolver() {
		return rResolver;
	}
	public void setrResolver(User rResolver) {
		this.rResolver = rResolver;
	}
	public ReimbursementType getrType() {
		return rType;
	}
	public void setrType(ReimbursementType rType) {
		this.rType = rType;
	}
}
