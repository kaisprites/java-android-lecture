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
	for(Cookie x : list) {
		if(x.getName().equals("JSESSIONID"))
			continue;
		x.setMaxAge(0);
		response.addCookie(x);
	}
%>
쿠키삭제됨
</body>
</html>