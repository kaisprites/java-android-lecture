<%@page import="bean.MemberVO"%>
<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	String id = request.getParameter("id");
	MemberDAO dao = new MemberDAO();
	MemberVO vo = dao.read(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><%= vo.getId() %> 님의 회원정보 검색내용</h3>
<hr color="red">
<table>
	<tr>
		<td>id</td>
		<td><%= vo.getId() %></td>
	</tr>
	<tr>
		<td>name</td>
		<td><%= vo.getName() %></td>
	</tr>
	<tr>
		<td>tel</td>
		<td><%= vo.getTel() %></td>
	</tr>
</table>
<hr color="green">
<a href="index.html">처음페이지로</a>
<a href="update.jsp?id=<%=vo.getId()%>">수정</a>
<a href="delete.jsp?id=<%=vo.getId()%>">삭제</a>
</body>
</html>