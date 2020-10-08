<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
	int grade = Integer.parseInt(request.getParameter("grade"));
    
    String result = "보통";
	if(grade >= 90) {
		result = "최우수";
	} else if(grade >= 80) {
		result = "우수";
	}
%><%= result %>