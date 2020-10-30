<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="Hi?name=hong">hi서블릿호출</a>
<form action="Hi" method="post">
	이름입력: <input type="text" name="name">
	<button type="submit">hi</button>
</form>

</body>
</html>