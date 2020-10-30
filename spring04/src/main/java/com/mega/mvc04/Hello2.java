package com.mega.mvc04;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String id;
	String pw;
	
    public void init (ServletConfig config) {
    	id = config.getInitParameter("id");
    	pw = config.getInitParameter("pw");
    }
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("welcome!! get!!");
		response.getWriter().println("id: " + id);
		response.getWriter().println("pw: " + pw);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("welcome!! post!!");
		response.getWriter().println("id: " + id);
		response.getWriter().println("pw: " + pw);
	}

}
