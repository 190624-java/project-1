package com.revature.servlets;

import java.awt.List;
import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAOImps.RequestDAOImp;
import com.revature.beans.Request;

/**
 * Servlet implementation class ViewPending
 */
@WebServlet("/ViewPending")
public class ViewPending extends HttpServlet {
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPending() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest clientReq, HttpServletResponse response) throws ServletException, IOException {
		//TODO from viewPersonalPending
		//expects (String userID)
				int userID = Integer.valueOf(clientReq.getParameter("userID")).intValue();
				
				RequestDAOImp rD = new RequestDAOImp();
				com.revature.beans.Request r;
				LinkedList<com.revature.beans.Request> reqs = (LinkedList<Request>) rD.getPersonalPending(userID);
				ObjectMapper om = new ObjectMapper();
				response.getWriter().write(om.writeValueAsString(reqs));
	}

}
