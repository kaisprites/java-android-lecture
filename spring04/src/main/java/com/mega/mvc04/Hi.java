package com.mega.mvc04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//클래스 Hi를 서블릿 구현 
public class Hi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String id;
       
    //기본생성자
    public Hi() {
        
    }
    
    //상속받은 Service method가 있다 요청방식에 따라 doGet 또는 doPost를 호출한다
	//jsp의 모든 코드는 서블릿의 service() 메서드로 구현
    //jsp의 모든 변수는 service( )지역변수
	//@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    //
    
    public void init (ServletConfig config) {
    	id = config.getInitParameter("id");
    	System.out.println(id);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 요청됨");
		String name = request.getParameter("name");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("이름: " + name);
	}
	
	//@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 요청됨");
		String name = request.getParameter("name");
		response.getWriter().println("이름: " + name);
	}

}
