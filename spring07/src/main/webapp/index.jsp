<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>SPRING5PROJECT</h3>
<p><a href = "list2.do">전체검색</a></p>
<hr>
<form action="create2.do">
	<p>id: <input type="text" name="id"></p>
	<p>pw: <input type="text" name="pw"></p>
	<p>name: <input type="text" name="name"></p>
	<p>tel: <input type="text" name="tel"></p>
	<p><button>submit create</button></p>
</form>
<hr>
<form action="delete2.do">
	<p>id: <input type="text" name="id"></p>
	<p>pw: <input type="text" name="pw"></p>
	<p><button>submit delete</button></p>
</form>

<form action="update2.do">
	<p>id: <input type="text" name="id"></p>
	<p>pw modify: <input type="text" name="pw"></p>
	<p>name modify: <input type="text" name="name"></p>
	<p>tel modify: <input type="text" name="tel"></p>
	<p><button>submit update</button></p>
</form>
</body>
</html>