package com.revature.servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAOImps.AccountDAOImp;
import com.revature.DAOImps.RequestDAOImp;
import com.revature.beans.Account;
import com.revature.beans.Request;

/**
 * Servlet implementation class ViewAccountInfo
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ViewAccountInfo" })
public class ViewAccountInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAccountInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest clientReq, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO from viewPersonalPending
		// expects (String userID)
		int userID;
		Integer bigI;
		HttpSession sess = clientReq.getSession();
		if(sess==null) {
			//try to get the userID from a requestParam
			bigI = ((Integer)clientReq.getAttribute("userID"));
			if(bigI!=null) userID = bigI.intValue();	
			else {
					System.out.println("Error: no session or passed userID on getting account info");
					return;
			}
		} else {
			
			//try to get the userID from the session
			bigI = (Integer)sess.getAttribute("userID");
			if(bigI==null) {
				System.out.println("Error: no session or passed userID on getting account info");
				return;
			} else {
				//continue the assignment.
				userID = bigI.intValue();
			}
		}
		
		

		AccountDAOImp aD = new AccountDAOImp();
		Account acc = aD.getAccount(userID);
		ObjectMapper om = new ObjectMapper();
		response.getWriter().write(om.writeValueAsString(acc));
	}

}
