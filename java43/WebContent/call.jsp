<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
	String result = "성인이 아닙니다";
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	if(Integer.parseInt(age) >= 18) {
		result = "성인입니다";
	}
%><%= result %>