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
<% session.setAttribute("name", "박길동"); %>
<% application.setAttribute("count", 100); %>
<a href = "viewsession.jsp">세션보기</a>
<a href = "viewsession2.jsp">세션보기2</a>
</body>
</html>