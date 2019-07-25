package com.revature.project1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project1.beans.*;
import com.revature.project1.dbDAOimpl.EmployeeDAOImpl;


public class InformationChangeServlet extends HttpServlet {
       
	//the two sections of hard coded employee will need to be taken from the session variable
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		int id = (int) session.getAttribute("emp_id");
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		Employee e = edi.getEmployee(id);//hard coded to john smith for right now
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().print(mapper.writeValueAsString(e));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String hometownNew = request.getParameter("hometown");
		int phoneNew = Integer.parseInt(request.getParameter("phone"));
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		int id=(int) session.getAttribute("emp_id");
		Employee e = edi.getEmployee(id);//hard coded value so that we change john smith
		
		e=edi.updateEmployee(hometownNew, phoneNew, e);
		response.sendRedirect("/project1/app/account.html");
	}

}
