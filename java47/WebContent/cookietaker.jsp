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
	Cookie[] list = request.getCookies();
	out.println("��Ű����: "+list.length+"��<br>");
	for(Cookie x : list) {
		if(x.getName().equals("JSESSIONID"))
			continue;
%>
	Cookie name: <%= x.getName() %>, Cookie value: <%= x.getValue() %><br>
<%
	x.setMaxAge(0);
}
%>
</body>
</html>