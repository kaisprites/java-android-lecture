<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>수정페이지</h3>
검색결과: ${bbsvoSession}
<hr>
<form action="insert.do">
	<p>번호: <input type="text" name="no" value="${ bbsvoSession.getNo() }"></p>
	<p>제목: <input type="text" name="title" value="${ bbsvoSession.getTitle() }"></p>
	<p>내용: <input type="text" name="content" value="${ bbsvoSession.getContent() }"></p>
	<p>작성자: <input type="text" name="writer" value="${ bbsvoSession.getWriter() }"></p>
	<p><button>submit</button></p>
</form>
</body>
</html>