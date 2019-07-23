package com.revature.project1.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project1.beans.*;
import com.revature.project1.dbDAOimpl.*;


public class ViewReimbursementServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6530469205548389441L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int check = Integer.parseInt(request.getParameter("re_status"));
		ReimbursementDAOImpl rdi= new ReimbursementDAOImpl();
		
		if(check==0) {
			//this finds all unprocessed reimbursements
			List<Reimbursement> reList= rdi.getReimbursementList(0);
			ObjectMapper mapper = new ObjectMapper();
			response.getWriter().print(mapper.writeValueAsString(reList));
			//
		}
		else if(check==1) {
			//this finds all approved
			List<Reimbursement> reList= rdi.getReimbursementList(1);
			ObjectMapper mapper = new ObjectMapper();
			response.getWriter().print(mapper.writeValueAsString(reList));
			//
		}
		else if(check==2) {
			//this finds all rejected
			List<Reimbursement> reList= rdi.getReimbursementList(2);
			ObjectMapper mapper = new ObjectMapper();
			response.getWriter().print(mapper.writeValueAsString(reList));
			//
		}
		else {
			//this is the fail
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//put the employee specific reimbursement list here
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		Employee e = edi.getEmployee(Integer.parseInt(request.getParameter("emp_id")));
		ReimbursementDAOImpl rdi  = new ReimbursementDAOImpl();
		List<Reimbursement> reList = rdi.getReimbursementList(e);
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().print(mapper.writeValueAsString(reList));
		 
		
		
		
		
	}

}
