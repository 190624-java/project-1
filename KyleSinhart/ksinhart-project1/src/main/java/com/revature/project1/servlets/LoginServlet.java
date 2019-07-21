package com.revature.project1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.project1.beans.Employee;
import com.revature.project1.dbDAOimpl.EmployeeDAOImpl;


public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("emp_email");
		String password = request.getParameter("password");
		EmployeeDAOImpl edi =  new EmployeeDAOImpl();
		Employee e = edi.getEmployee(email);
		//System.out.println(e.toString());
		if(e.getIsAdminNum()==0) {
			if(password.equals(e.getPass())) {
				response.sendRedirect("/project1/home.html");
			}
		}
		else if(e.getIsAdminNum()==1) {
			if(password.equals(e.getPass())) {
				response.sendRedirect("/project1/managerHome.html");
			}
		}
		else {
			
			response.sendRedirect("/project1/login.html");
		}
		
	}

}
