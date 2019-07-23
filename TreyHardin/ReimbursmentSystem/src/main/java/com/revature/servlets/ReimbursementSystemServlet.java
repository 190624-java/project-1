package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Employee;
import com.revature.dbDAOimpls.EmployeeImpl;
import com.revature.dbDAOimpls.dbConnectionHandler;
import com.revature.doa.Employeedoa;


public class ReimbursementSystemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Employeedoa employ = null;
	private Employee bean = null;
	
	@Override
	public void init() throws ServletException {
		employ = new EmployeeImpl();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		bean = employ.login(request.getParameter("username"), request.getParameter("password"));
		if(bean != null) {
			response.sendRedirect("/Project1/employeehompage.html");
			response.setStatus(201);
		}
		else {
			response.sendRedirect("/Project1/Issue.html");
		}
		
	}
	
	@Override
	public void destroy() {
		try {
			dbConnectionHandler.getConnection().close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
