<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
설정된 세션 id는 <%= session.getAttribute("id") %>
설정된 app count는 <%= application.getAttribute("count") %>
</body>
</html>