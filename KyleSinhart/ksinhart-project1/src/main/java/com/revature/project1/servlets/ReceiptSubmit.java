package com.revature.project1.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project1.beans.Employee;
import com.revature.project1.beans.Receipt;
import com.revature.project1.beans.Reimbursement;
import com.revature.project1.dbDAOimpl.EmployeeDAOImpl;
import com.revature.project1.dbDAOimpl.ReceiptDAOImpl;
import com.revature.project1.dbDAOimpl.ReimbursementDAOImpl;

@MultipartConfig
public class ReceiptSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		System.out.println("was destroyed");
		session.removeAttribute("re_id");
		response.sendRedirect("/project1/app/home.html");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Is this hit");
		HttpSession session = request.getSession(false);
		
		InputStream inputStream = null;
		Part filePart = request.getPart("photo");
		if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
		
		
		int id = (int) session.getAttribute("re_id");
		//int id=1;
		//int btnChoice = (int) session.getAttribute("btn");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String v_name=request.getParameter("v_name");
		
		ReceiptDAOImpl recDI = new ReceiptDAOImpl();
		recDI.createReceipt(new Receipt(id,amount,v_name), inputStream);
		
		response.sendRedirect("/project1/app/submitReceipt.html");
		//ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
		//ObjectMapper mapper = new ObjectMapper();
		//Reimbursement re= (Reimbursement) mapper.readValue(request.getInputStream(), Reimbursement.class);
		
	}

}
