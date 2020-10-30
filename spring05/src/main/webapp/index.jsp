<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
SPRING5PROJECT
<form action="insert.do">
	<p>번호: <input type="text" name="no"></p>
	<p>제목: <input type="text" name="title"></p>
	<p>내용: <input type="text" name="content"></p>
	<p>작성자: <input type="text" name="writer"></p>
	<p><button>submit</button></p>
</form>
<hr>
<form action="create2.do">
	<p>id: <input type="text" name="id"></p>
	<p>pw: <input type="text" name="pw"></p>
	<p>name: <input type="text" name="name"></p>
	<p>tel: <input type="text" name="tel"></p>
	<p><button>submit</button></p>
</form>
</body>
</html>