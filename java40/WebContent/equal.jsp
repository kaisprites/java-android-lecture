<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pid = request.getParameter("id");
	String text = "확인되었습니다";
	if(pid.length() < 5) text = "아이디가 5글자이상이어야 합니다 ";
	else {
		MemberDAO dao = new MemberDAO();
		boolean result = dao.checkID(pid);
		if(result) text = "아이디가 중복입니다"; 
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=text%>
</body>
</html>