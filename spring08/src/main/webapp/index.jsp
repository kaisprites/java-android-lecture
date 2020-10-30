<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>PRODUCT</h3><br>
<form action="create.do">
	<p>title: <input type="text" name="title"></p>
	<p>content: <input type="text" name="content"></p>
	<p>price: <input type="text" name="price"></p>
	<p>tel: <input type="text" name="tel"></p>
	<button>submit create</button>
</form>
<hr>
<form action="one.do">
	<p>id: <input type="text" name="id"></p>
	<button>submit one</button>
</form>
<hr>
<form action="list.do">
	<button>submit list</button>
</form>
<hr>
<form action="update.do">
	<p>id: <input type="text" name="id"></p>
	<p>title modify: <input type="text" name="title"></p>
	<p>content modify: <input type="text" name="content"></p>
	<p>price modify: <input type="text" name="price"></p>
	<p>tel modify: <input type="text" name="tel"></p>
	<button>submit update</button>
</form>
<form action="delete.do">
	<p>id: <input type="text" name="id"></p>
	<button>submit delete</button>
</form>
</body>
</html>