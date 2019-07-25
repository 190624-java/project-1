package com.revature.beans;

public class Account {

	private String userName;
	private String password;
	private String name;
	private String email;
	private int userID;
	private int type;
	
	public Account() {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public int getType() {
		return this.type;
	}

	public void setType(int userType) {
		this.type = userType;
	}

	public void setUserID(int userID) {
		this.userID = userID;
		
	}
	public int getUserID() {
		return this.userID;
	}

	
	
}
