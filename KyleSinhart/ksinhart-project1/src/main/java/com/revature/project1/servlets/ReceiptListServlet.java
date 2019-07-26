package com.revature.project1.servlets;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project1.beans.Employee;
import com.revature.project1.beans.Receipt;
import com.revature.project1.beans.Reimbursement;
import com.revature.project1.dbDAOimpl.EmployeeDAOImpl;
import com.revature.project1.dbDAOimpl.ReceiptDAOImpl;
import com.revature.project1.dbDAOimpl.ReimbursementDAOImpl;


public class ReceiptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int rec_id=Integer.parseInt(request.getParameter("rec_id"));
    	ReceiptDAOImpl rdi= new ReceiptDAOImpl();
		Receipt rec= rdi.getReceipt(rec_id);
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().print(mapper.writeValueAsBytes(rec.getBytes()));
		
//		try {
//			OutputStream out = rec.getPhoto().setBinaryStream(1);
//			response.getWriter().print(mapper.writeValueAsBytes(out));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//System.out.println(mapper.writeValueAsBytes(out));
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession(false);
		System.out.println("Is this hit");
		ReimbursementDAOImpl rdi= new ReimbursementDAOImpl();
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement re= (Reimbursement) mapper.readValue(request.getInputStream(), Reimbursement.class);
		re = rdi.getReimbursementbyRe(re.getRe_id()); 
		ReceiptDAOImpl recdi= new ReceiptDAOImpl();
		List<Receipt> recList = recdi.getReceiptList(re.getRe_id());
		//System.out.println(recList.toString());
		response.getWriter().print(mapper.writeValueAsString(recList));
	}

}
