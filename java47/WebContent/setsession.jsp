<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% session.setAttribute("id", "park"); %>
<% session.setAttribute("name", "�ڱ浿"); %>
<% application.setAttribute("count", 100); %>
<a href = "viewsession.jsp">���Ǻ���</a>
<a href = "viewsession2.jsp">���Ǻ���2</a>
</body>
</html>