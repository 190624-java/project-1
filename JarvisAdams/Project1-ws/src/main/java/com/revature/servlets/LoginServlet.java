package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAOImps.AccountDAOImp;
import com.revature.beans.Account;
import com.revature.exceptions.NonexistantUser;
import com.revature.utilities.UType;

public class LoginServlet extends HttpServlet{
	
	public void init(){
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Got to the LoginServlet doGet()");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Started Login Servlet doPost()");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		/* Syntax from Jessica on parsing a stringified JSON object that was posted from Javascript in the send() method of the xhr object. 
		ObjectMapper om = new ObjectMapper();
		om.readValue(req.getInputStream(), yourClass.class);
		*/
		PrintWriter pw = resp.getWriter();
		
		
		//Check that the user exists in the database
		AccountDAOImp a_dao = new AccountDAOImp();
		Account account = null;
		try {
			account = a_dao.getAccount(username);
			//get the session that is associated to the user's IP address that is automatically timed by the server.
			//store a session variable on that session 
			HttpSession sess = req.getSession();
			sess.setAttribute("loggedIn", true);
			sess.setAttribute("userID",new Integer(account.getUserID()));
			sess.setAttribute("username", username);
			sess.setAttribute("name", account.getName());
			sess.setAttribute("email", account.getEmail());
			sess.setAttribute("type", new Integer(account.getType()));
			
			switch(account.getType()) {
				case UType.EMPLOYEE:
					resp.sendRedirect("/J2Inc/EmployeeHome.html");
					break;
				case UType.MANAGER:
					resp.sendRedirect("/J2Inc/ManagerHome.html");
			}
			
		} catch (NonexistantUser e) {
			pw.write("Invalid Username or Password");
		}		
	}
	
}
