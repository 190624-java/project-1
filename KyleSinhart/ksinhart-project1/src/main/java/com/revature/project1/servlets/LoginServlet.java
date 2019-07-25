package com.revature.project1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.project1.beans.Employee;
import com.revature.project1.dbDAOimpl.EmployeeDAOImpl;


public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/project1/login.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String email = request.getParameter("emp_email");
		String password = request.getParameter("password");
		EmployeeDAOImpl edi =  new EmployeeDAOImpl();
		Employee e = edi.getEmployee(email);
		//System.out.println(e.toString());
		
//		if (AuthenticationService.isValidUser(username, password)) {
//			System.out.println("valid user");
//			session.setAttribute("username", username);
//			session.setAttribute("problem", null);
//			response.sendRedirect("/hero-app/app/hero/go");
//		} else {
//			System.out.println("invalid user");
//			session.setAttribute("problem", "incorrect login");
//			response.sendRedirect("/hero-app/login");
//		}
		
		if(e.getIsAdminNum()==0) {
			if(password.equals(e.getPass())) {
				System.out.println("valid user");
				session.setAttribute("email", email);
				session.setAttribute("emp_id", e.getEmp_id());
				response.sendRedirect("/project1/home.html");
			}
		}
		else if(e.getIsAdminNum()==1) {
			if(password.equals(e.getPass())) {
				System.out.println("valid user");
				session.setAttribute("email", email);
				session.setAttribute("emp_id", e.getEmp_id());
				response.sendRedirect("/project1/managerHome.html");
			}
		}
		else {
			
			response.sendRedirect("/project1/login.html");
		}
		
	}

}
