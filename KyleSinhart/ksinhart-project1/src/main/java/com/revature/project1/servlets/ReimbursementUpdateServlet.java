package com.revature.project1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.project1.beans.*;
import com.revature.project1.dbDAOimpl.ReimbursementDAOImpl;


public class ReimbursementUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee m = new Employee();//get session variable for manager id//just hardcoded for now
		m.setEmp_id(2);
		int status = Integer.parseInt(request.getParameter("status"));
		Reimbursement re = new Reimbursement(Integer.parseInt(request.getParameter("re_id")));
		
		ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
		re=rdi.updateReimbursement(re, m, status);
		
	}

}
