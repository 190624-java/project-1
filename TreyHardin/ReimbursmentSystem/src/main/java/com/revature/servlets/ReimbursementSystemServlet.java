package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.dbDAOimpls.EmployeeImpl;
import com.revature.dbDAOimpls.ReimbursementImpl;
import com.revature.dbDAOimpls.dbConnectionHandler;
import com.revature.doa.Employeedoa;
import com.revature.doa.Reimbursementdao;


public class ReimbursementSystemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Employeedoa employ = null;
	private Reimbursementdao reim = null;
	
	@Override
	public void init() throws ServletException {
		employ = new EmployeeImpl();
		reim = new ReimbursementImpl();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
		System.out.println(path);
		
		switch(path) {
		
		case "/Project1/app/servlet/info":
			Employee employee = (Employee) request.getSession(false).getAttribute("employeebean");
			System.out.println("retrieving employee " + employee.getId());
			ObjectMapper mapper = new ObjectMapper();
			response.getWriter().print(mapper.writeValueAsString(employee));
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
		System.out.println(path);
		
		
		switch(path) {
		
		case "/Project1/app/servlet/login":
			Employee bean = employ.login(request.getParameter("username"), request.getParameter("password"));
			request.getSession().setAttribute("employeebean", bean);
			if(bean != null) {
				response.sendRedirect("/Project1/employeehompage.html");
			}
			else {
				response.sendRedirect("/Project1/");
				
			}
			break;
			
		case "/Project1/app/servlet/logout":
			request.getSession(false).invalidate();
			response.sendRedirect("/Project1/");
			break;
			
		case "/Project1/app/servlet/editInfo":
			Employee info = (Employee) request.getSession(false).getAttribute("employeebean");
			info.setFname(request.getParameter("fname"));
			info.setLname(request.getParameter("lname"));
			employ.updateEmployee(info);
			response.sendRedirect("/Project1/employeehompage.html");
			break;
			
		case "/Project1/app/servlet/request":
			Employee reimRequest = (Employee) request.getSession(false).getAttribute("employeebean");
			reim.createReimbursement(Double.parseDouble(request.getParameter("amount")), reimRequest.getId());
			response.sendRedirect("/Project1/submitRequest.html");
			break;
			
		
//			request.getSession(false).invalidate();
//			response.sendRedirect("/Project1/");
//			response.setStatus(201);
//			break;
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
