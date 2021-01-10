<%@page import="bean.MemberVO"%>
<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- useBean actionTag: create instance -->    
<jsp:useBean id="vo" class="bean.MemberVO"></jsp:useBean>
<jsp:setProperty property="*" name="vo"/>

<%
	MemberDAO dao = new MemberDAO();
	boolean result = dao.update(vo);
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