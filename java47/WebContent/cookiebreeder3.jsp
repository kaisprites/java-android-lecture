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
	Cookie c1 = new Cookie("subject", "spring");
	Cookie c2 = new Cookie("location", "709ȣ");
	Cookie c3 = new Cookie("person", "100��");
	response.addCookie(c1);
	response.addCookie(c2);
	response.addCookie(c3);
	%>
<a href="cookietaker.jsp">��Ű���뺸��</a>
</body>
</html>