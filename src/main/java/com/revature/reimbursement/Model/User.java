package com.revature.reimbursement.Model;

public class User {
	
	private int userId;
	private String username;
	private String password;
	private String userFName;
	private String userLName;
	private String userEmail;
	private UserRole userRole;
	
	public User() {}
	public User(int userId, String username, String userFName, String userLName, String userEmail, UserRole userRole) {
		super();
		this.userId = userId;
		this.username = username;
		this.userFName = userFName;
		this.userLName = userLName;
		this.userEmail = userEmail;
		this.userRole = userRole;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserFName() {
		return userFName;
	}
	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}
	public String getUserLName() {
		return userLName;
	}
	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
}
