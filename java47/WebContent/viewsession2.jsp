<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- Expression Language(EL): printable when attribute set -->
������ ���� id�� <%= session.getAttribute("id") %><br>
������ ���� name��  ${name} <br>
������ app count�� <%= application.getAttribute("count") %>
</body>
</html>