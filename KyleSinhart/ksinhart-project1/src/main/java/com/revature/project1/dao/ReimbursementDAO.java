package com.revature.project1.dao;

import java.util.List;

import com.revature.project1.beans.*;

public interface ReimbursementDAO {
	
	public Reimbursement createReimbursement(Reimbursement re);
	
	public Reimbursement getReimbursement(int re);
	
	public Reimbursement updateReimbursement(Reimbursement re, Employee m,int status);
	
	public List<Reimbursement> getReimbursementList(int status);
	
	public List<Reimbursement> getReimbursementList(Employee e);
	
	public void deleteReimbursement(Reimbursement re);
	
	
}
