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
<h1> <%= vo.getId() %> 님의 회원정보 수정 페이지 </h1>
<hr color="red">
<form action="update2.jsp">
<table>
	<tr>
		<td>id</td>
		<td><input type="hidden" name="id" value="<%=vo.getId() %>"></td>
	</tr>
	<tr>
		<td>pw</td>
		<td><input type="text" name="pw" value="<%=vo.getPw() %>"></td>
	</tr>
	<tr>
		<td>name</td>
		<td><input type="text" name="name" value="<%=vo.getName() %>"></td>
	</tr>
	<tr>
		<td>tel</td>
		<td><input type="text" name="tel" value="<%=vo.getTel() %>"></td>
	</tr>
</table>
<button name="submit">submit</button>
</form>
</body>
</html>