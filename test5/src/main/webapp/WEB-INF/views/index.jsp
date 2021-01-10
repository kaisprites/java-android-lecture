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
<form action="create" method="post">
	<input type="text" name="name" placeholder="name" size=20>
	<input type="text" name="content" placeholder="content" size=40>
	<button type="submit">submit</button>
</form>
<table>
	<c:forEach var="item" items="${list}" varStatus="status">
		<tr>
			<td style="border: 1px solid black">${item.name}</td>
			<td style="border: 1px solid black">${item.content}</td>
		</tr>
	</c:forEach>
</table>
<p><img src="<c:url value='/resources/image/cat01.jpg'/>" height=300px/>
<img src="<c:url value='/resources/image/cat02.jpg'/>" height=300px/>
<img src="<c:url value='/resources/image/cat03.jpg'/>" height=300px/></p>
</body>
</html>