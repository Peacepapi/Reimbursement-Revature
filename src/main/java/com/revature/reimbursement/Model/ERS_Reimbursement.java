package com.revature.reimbursement.Model;

import java.sql.Blob;
import java.time.LocalDate;

public class ERS_Reimbursement {
	
	private int reimb_Id;
	private double reimb_Amount;
	private LocalDate reimb_Submitted;
	private LocalDate reimb_Resolved;
	private String reimb_Description;
	private Blob reimb_Receipt;
	private int reimb_Author;
	private int reimb_Resolver;
	private int reimb_Status_Id;
	private int reimb_Type_Id;
	public int getReimb_Id() {
		return reimb_Id;
	}
	public void setReimb_Id(int reimb_Id) {
		this.reimb_Id = reimb_Id;
	}
	public double getReimb_Amount() {
		return reimb_Amount;
	}
	public void setReimb_Amount(double reimb_Amount) {
		this.reimb_Amount = reimb_Amount;
	}
	public LocalDate getReimb_Submitted() {
		return reimb_Submitted;
	}
	public void setReimb_Submitted(LocalDate reimb_Submitted) {
		this.reimb_Submitted = reimb_Submitted;
	}
	public LocalDate getReimb_Resolved() {
		return reimb_Resolved;
	}
	public void setReimb_Resolved(LocalDate reimb_Resolved) {
		this.reimb_Resolved = reimb_Resolved;
	}
	public String getReimb_Description() {
		return reimb_Description;
	}
	public void setReimb_Description(String reimb_Description) {
		this.reimb_Description = reimb_Description;
	}
	public Blob getReimb_Receipt() {
		return reimb_Receipt;
	}
	public void setReimb_Receipt(Blob reimb_Receipt) {
		this.reimb_Receipt = reimb_Receipt;
	}
	public int getReimb_Author() {
		return reimb_Author;
	}
	public void setReimb_Author(int reimb_Author) {
		this.reimb_Author = reimb_Author;
	}
	public int getReimb_Resolver() {
		return reimb_Resolver;
	}
	public void setReimb_Resolver(int reimb_Resolver) {
		this.reimb_Resolver = reimb_Resolver;
	}
	public int getReimb_Status_Id() {
		return reimb_Status_Id;
	}
	public void setReimb_Status_Id(int reimb_Status_Id) {
		this.reimb_Status_Id = reimb_Status_Id;
	}
	public int getReimb_Type_Id() {
		return reimb_Type_Id;
	}
	public void setReimb_Type_Id(int reimb_Type_Id) {
		this.reimb_Type_Id = reimb_Type_Id;
	}
}
