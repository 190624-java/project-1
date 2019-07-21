package com.revature.project1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.project1.beans.Employee;
import com.revature.project1.dbDAOimpl.EmployeeDAOImpl;


public class RegistrationServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		System.out.println(request.getParameter("fname"));
		//Employee e = new Employee(request.getParameter("fname"),request.getParameter("lname"),request.getParameter("password"),request.getParameter("emp_email"),0,request.getParameter("hometown"),Integer.parseInt(request.getParameter("phone")));
		Employee e = new Employee(request.getParameter("fname"),request.getParameter("lname"),request.getParameter("password"),request.getParameter("emp_email"),request.getParameter("hometown"));
		e = edi.createEmployee(e);
		response.sendRedirect("/project1/login.html");
	}

}
