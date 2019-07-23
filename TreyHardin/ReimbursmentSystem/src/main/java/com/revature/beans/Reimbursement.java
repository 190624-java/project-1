package com.revature.beans;

public class Reimbursement {
	
	private int reimbursmentId;
	private int employeeId;
	private int managerId;
	private double reimbursmentAmount;
	private boolean approved;
	
	public Reimbursement(int reimbursmentId, int employeeId, int managerId, double reimbursmentAmount,
			boolean approved) {
		super();
		this.reimbursmentId = reimbursmentId;
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.reimbursmentAmount = reimbursmentAmount;
		this.approved = approved;
	}

	public Reimbursement(int employeeId, double reimbursmentAmount) {
		super();
		this.employeeId = employeeId;
		this.reimbursmentAmount = reimbursmentAmount;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public double getReimbursmentAmount() {
		return reimbursmentAmount;
	}

	public void setReimbursmentAmount(double reimbursmentAmount) {
		this.reimbursmentAmount = reimbursmentAmount;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public int getReimbursmentId() {
		return reimbursmentId;
	}
	
	public void setReimbursmentId(int reimbursmentId) {
		this.reimbursmentId = reimbursmentId;
	}

	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
