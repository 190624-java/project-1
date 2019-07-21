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
		
		//this finds all unprocessed remimbursements
		ReimbursementDAOImpl rdi= new ReimbursementDAOImpl();
		List<Reimbursement> reList= rdi.getReimbursementList(0);
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().print(mapper.writeValueAsString(reList));
		//
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
