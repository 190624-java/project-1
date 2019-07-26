package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.User;
import dao.UserDAO;
import dbDAOImpl.UserDAOImpl;

public class UserInfoServlet extends HttpServlet {

	private UserDAO user = new UserDAOImpl();

	@Override
	public void init() throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, JsonProcessingException, IOException {
		System.out.println("we got here");
		List<User> userList = user.getAllUsers();
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(userList));
		response.getWriter().write(mapper.writeValueAsString(userList));
		
		//response.sendRedirect("../manager.html");
		//request.getRequestDispatcher("/manager.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, JsonParseException, JsonMappingException, IOException {
		HttpSession session = request.getSession();
		System.out.println(request);
		String uname = session.getAttribute("username").toString();
		System.out.println(uname);
//		String uid = request.getParameter("user_id");
//		String uName = request.getParameter("username");
//		String fName = request.getParameter("firstName");
//		String lName = request.getParameter("lastName");
//		String gender = request.getParameter("gender");
//		String address = request.getParameter("address");
		User u = user.getUserByUsername(uname);
//		System.out.println(uName);
//		System.out.println(fName);
//		System.out.println(u.getUsername());
		ObjectMapper mapper = new ObjectMapper();
		u = (User) mapper.readValue(request.getInputStream(), User.class);
//		u.setFirstName(fName);
//		u.setLastName(lName);
//		u.setGender(gender);
//		u.setAddress(address);
		System.out.println(u.toString());
		user.updateUserInfo(u);
		response.setStatus(201);
	}
}
