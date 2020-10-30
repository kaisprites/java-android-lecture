<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>게시물등록정보</h3>
<hr>
<p> no: ${bbsVO.no} </p>
<p> title: ${bbsVO.title} </p>
<p> content: ${bbsVO.content} </p>
<p> writer: ${bbsVO.writer} </p>
<a href="index.jsp">처음으로</a>
<a href="update.do">수정하기</a>
<a href="delete.do">삭제하기</a>
</body>
</html>