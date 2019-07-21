package com.revature.project1.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project1.beans.Receipt;
import com.revature.project1.dbDAOimpl.ReceiptDAOImpl;


public class ReceiptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int re_id=Integer.parseInt(request.getParameter("re_id"));
    	ReceiptDAOImpl rdi= new ReceiptDAOImpl();
		List<Receipt> recList= rdi.getReceiptList(re_id);
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().print(mapper.writeValueAsString(recList));
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
