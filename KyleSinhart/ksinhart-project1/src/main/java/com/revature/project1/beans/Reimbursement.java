package com.revature.project1.beans;

import java.sql.Date;
import java.util.List;

public class Reimbursement {
	private int re_id;
	private int emp_id;
	private int re_status;//0 for unprocessed / 1 for approved / 2 for rejected
	private double amount;
	private Date date_of;
	private String description;
	private int manager_id;
	private List<Receipt> attRec;
	private boolean statusOf;
	
	
	public Reimbursement(int emp_id, double amount, Date date_of, String description) {
		//super();
		this.emp_id = emp_id;
		this.re_status=0;
		this.amount = amount;
		this.date_of = date_of;
		this.description = description;
	}
	
	public Reimbursement(int re_id) {
		this.re_id=re_id;
	}
	
	
	public Reimbursement(int re_id, int emp_id, int re_status, double amount, Date date_of, String description,
			int manager_id) {
		super();
		this.re_id = re_id;
		this.emp_id = emp_id;
		this.re_status = re_status;
		this.amount = amount;
		this.date_of = date_of;
		this.description = description;
		this.manager_id = manager_id;
	}


	public int getRe_id() {
		return re_id;
	}
	public void setRe_id(int Re_id) {
		this.re_id = Re_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getRe_status() {
		return re_status;
	}
	public void setRe_status(int re_status) {
		this.re_status = re_status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate_of() {
		return date_of;
	}
	public void setDate_of(Date date_of) {
		this.date_of = date_of;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	
	public List<Receipt> getAttRec() {
		return attRec;
	}
	public void setAttRec(List<Receipt> attRec) {
		this.attRec = attRec;
	}
	public boolean isStatusOf() {
		return statusOf;
	}
	public void setStatusOf(boolean statusOf) {
		this.statusOf = statusOf;
	}
	
}
