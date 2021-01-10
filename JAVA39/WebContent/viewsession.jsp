<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(session.getAttribute("id") != null) { %>
<h1> <%= session.getAttribute("id") %> 님을 환영합니다. </h1>
<% } else { %>
<h1> guest 님을 환영합니다. </h1>
<% } %>
<a href="endsession.jsp">logout</a>
</body>
</html>