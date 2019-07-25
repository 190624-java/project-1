package com.revature.utilities;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.exceptions.NotLoggedIn;

public class Util {

	
	protected static boolean isLoggedIn(HttpServletRequest req) throws NotLoggedIn {
		//get the session that is associated to the user's IP address that is automatically timed by the server.
		//store a session variable on that session 
		Boolean b = (Boolean)req.getSession().getAttribute("loggedIn");
		if(b==null) throw new NotLoggedIn();
		else return b.booleanValue();
		//check for null attribute, if null, then the session is not logged in, and return from the servlet with an error message.
	}
}
