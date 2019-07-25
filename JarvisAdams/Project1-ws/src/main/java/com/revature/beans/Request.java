package com.revature.beans;

public class Request {

	private int reqID;
	private float reqAmount;
	private String description;
	private int status;
	private int userID;
	private String resolvingManager;

	public Request() {
	}

	public Request(int reqID, float reqAmount, String description, int status, int userID, String resolvingManager) {
		super();
		this.reqID = reqID;
		this.reqAmount = reqAmount;
		this.description = description;
		this.status = status;
		this.userID = userID;
	}

	public int getReqID() {
		return reqID;
	}

	public void setReqID(int reqID) {
		this.reqID = reqID;
	}

	public float getReqAmount() {
		return reqAmount;
	}

	public void setReqAmount(float reqAmount) {
		this.reqAmount = reqAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getResolvingManager() {
		return resolvingManager;
	}

	public void setResolvingManager(String resolvingManager) {
		this.resolvingManager = resolvingManager;
	}

}
