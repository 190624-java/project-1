package com.revature.project1.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.project1.beans.Employee;
import com.revature.project1.dbDAOimpl.EmployeeDAOImpl;

import com.fasterxml.jackson.databind.ObjectMapper;


public class EmployeeListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 80938815661192353L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		EmployeeDAOImpl edi= new EmployeeDAOImpl();
		List<Employee> empList= edi.getEmployeeList();
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().print(mapper.writeValueAsString(empList));
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
