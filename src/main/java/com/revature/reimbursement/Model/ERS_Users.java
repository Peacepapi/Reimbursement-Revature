package com.revature.reimbursement.Model;

public class ERS_Users {
	
	private int ers_Users_Id;
	private String ers_Username;
	private String ers_Password;
	private String user_First_Name;
	private String user_Last_Name;
	private String user_Email;
	private int user_Role_Id;
	
	public int getErs_Users_Id() {
		return ers_Users_Id;
	}
	public void setErs_Users_Id(int ers_Users_Id) {
		this.ers_Users_Id = ers_Users_Id;
	}
	public String getErs_Username() {
		return ers_Username;
	}
	public void setErs_Username(String ers_Username) {
		this.ers_Username = ers_Username;
	}
	public String getErs_Password() {
		return ers_Password;
	}
	public void setErs_Password(String ers_Password) {
		this.ers_Password = ers_Password;
	}
	public String getUser_First_Name() {
		return user_First_Name;
	}
	public void setUser_First_Name(String user_First_Name) {
		this.user_First_Name = user_First_Name;
	}
	public String getUser_Last_Name() {
		return user_Last_Name;
	}
	public void setUser_Last_Name(String user_Last_Name) {
		this.user_Last_Name = user_Last_Name;
	}
	public String getUser_Email() {
		return user_Email;
	}
	public void setUser_Email(String user_Email) {
		this.user_Email = user_Email;
	}
	public int getUser_Role_Id() {
		return user_Role_Id;
	}
	public void setUser_Role_Id(int user_Role_Id) {
		this.user_Role_Id = user_Role_Id;
	}
}
