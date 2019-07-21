package com.revature.project1.beans;

import java.util.List;

public class Employee {
	private int emp_id;
	private String fname;
	private String lname;
	private String pass;
	private String email;
	private int isAdminNum;
	private String hometown;
	private int phone;
	
	private List<Reimbursement> re_list;
	private boolean isAdmin;
	
	public Employee() {
		this.isAdminNum = 3;//signifies a bad login
	}
	
	public Employee(boolean valid) {
		if(!valid) {
			this.isAdminNum = 3;//signifies a bad login
		}
	}
	
	public Employee(int emp_id, String fname, String lname, String pass, String email, int isAdminNum, String hometown,
			int phone) {
		super();
		this.emp_id = emp_id;
		this.fname = fname;
		this.lname = lname;
		this.pass = pass;
		this.email = email;
		this.isAdminNum = isAdminNum;
		this.hometown = hometown;
		this.phone = phone;
	}

	public Employee(String fname, String lname, String pass, String email, int isAdminNum, String hometown, int phone) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.pass = pass;
		this.email = email;
		this.isAdminNum = isAdminNum;
		this.hometown = hometown;
		this.phone = phone;
	}
	
	
	
	public Employee(String fname, String lname, String pass, String email, String hometown) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.pass = pass;
		this.email = email;
		this.hometown = hometown;
		this.isAdminNum = 0;
		this.phone = 12345;
	}

	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	public List<Reimbursement> getRe_list() {
		return re_list;
	}
	public void setRe_list(List<Reimbursement> re_list) {
		this.re_list = re_list;
	}
	public int getIsAdminNum() {
		return isAdminNum;
	}
	public void setIsAdminNum(int isAdminNum) {
		this.isAdminNum = isAdminNum;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", fname=" + fname + ", lname=" + lname + ", pass=" + pass + ", email="
				+ email + ", isAdminNum=" + isAdminNum + ", hometown=" + hometown + ", phone=" + phone + "]";
	}
	
}
