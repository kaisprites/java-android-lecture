<%@page import="bean.BBSDAO"%>
<%@page import="bean.BBSVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	BBSVO vo = new BBSVO();
	vo.setTitle(title);
	vo.setWriter(writer);
	vo.setContent(content);
	BBSDAO dao = new BBSDAO();
	
	dao.create(vo);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
전송되었습니다.
</body>
</html>