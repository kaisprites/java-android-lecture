<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 가입한 정보 확인하는 화면. View -->
<h2>당신의 가입 정보</h2>
<hr> <!-- 표현식(Expression)
 		-> 표현언어(Expression Language:EL) -->
당신의 id: ${memberDTO.id}<br>
당신의 pw: ${memberDTO.pw}<br>
당신의 name: ${memberDTO.name}<br>
당신의 tel: ${memberDTO.tel}<br> <!-- getTel() -->
</body>
</html>


