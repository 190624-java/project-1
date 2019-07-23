package com.revature.project1.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.project1.beans.*;
import com.revature.project1.dbDAOimpl.*;

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
	
	public static void updateLists() {
		try {
			
			Connection conn=ConnectionFactory.getConnection();
			/*
			new EmployeeDAOImpl().getEmployeeList();
			new ReimbursementDAOImpl().ge
			new ReceiptDAOImpl()
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
