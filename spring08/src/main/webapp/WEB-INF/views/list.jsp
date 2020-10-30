<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>전체정보</h3>
<c:forEach items="${bag}" var="productVO">
	<p>id: ${productVO.id }</p>
	<p>title: ${productVO.title}</p>
	<p>content: ${productVO.content}</p>
	<p>price: ${productVO.price}</p>
	<p>tel: ${productVO.tel}</p>
	<hr>
</c:forEach>
<p><a href="index.jsp">처음화면</a></p>
</body>
</html>