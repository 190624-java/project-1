package com.revature.project1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project1.beans.Employee;
import com.revature.project1.beans.Reimbursement;
import com.revature.project1.dbDAOimpl.EmployeeDAOImpl;
import com.revature.project1.dbDAOimpl.ReimbursementDAOImpl;


public class ReceiptSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Is this hit");
		ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement re= (Reimbursement) mapper.readValue(request.getInputStream(), Reimbursement.class);
		
	}

}
