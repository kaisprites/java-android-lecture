<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
	int grade = Integer.parseInt(request.getParameter("grade"));
    
    String result = "����";
	if(grade >= 90) {
		result = "�ֿ��";
	} else if(grade >= 80) {
		result = "���";
	}
%><%= result %>