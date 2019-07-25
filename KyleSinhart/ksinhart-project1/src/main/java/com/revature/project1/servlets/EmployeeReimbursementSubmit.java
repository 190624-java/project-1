package com.revature.project1.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.project1.beans.Reimbursement;
import com.revature.project1.dbDAOimpl.ReimbursementDAOImpl;


public class EmployeeReimbursementSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession session=request.getSession();
		
		//hard coded so emp_id 3 submits
		Reimbursement re = new ReimbursementDAOImpl().createReimbursement(new Reimbursement(3
				,Double.parseDouble(request.getParameter("amount"))
				,new Date(Long.parseLong(request.getParameter("date_of")))
				,request.getParameter("description")));
		
		
	}

}
