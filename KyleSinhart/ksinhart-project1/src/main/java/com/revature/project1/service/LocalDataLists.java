package com.revature.project1.service;

import java.util.List;

import com.revature.project1.beans.*;

public class LocalDataLists {
	
	private static List<Employee> empList;
	private static List<Reimbursement> reList;
	private static List<Receipt> recList;
	
	
	public static List<Employee> getEmpList() {
		return empList;
	}
	public static void setEmpList(List<Employee> empListloc) {
		empList = empListloc;
	}
	public static List<Reimbursement> getReList() {
		return reList;
	}
	public void setReList(List<Reimbursement> reListloc) {
		reList = reListloc;
	}
	public List<Receipt> getRecList() {
		return recList;
	}
	public void setRecList(List<Receipt> recListloc) {
		recList = recListloc;
	}
	
	
}
