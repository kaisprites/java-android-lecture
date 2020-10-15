<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie c1 = new Cookie("fruit", "apple");
	c1.setMaxAge(0);
	response.addCookie(c1);
%>
</body>
</html>