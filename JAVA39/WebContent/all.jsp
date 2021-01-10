<%@page import="java.util.List"%>
<%@page import="bean.MemberVO"%>
<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	MemberDAO dao = new MemberDAO();
    	List<MemberVO> list = dao.all();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td {
		width:100px;
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
</head>
<body>
<h3 style=color:blue>검색결과의 개수: <%= list.size() %>개</h3>
<table>
	<tr>
		<td> id </td>
		<td> pw </td>
		<td> name </td>
		<td> tel </td>
	</tr>
<% for(int i = 0; i < list.size(); i++) {
	MemberVO vo = list.get(i);%>
	<tr>
		<td> <%= vo.getId() %> </td>
		<td> <%= vo.getPw() %> </td>
		<td> <%= vo.getName() %> </td>
		<td> <%= vo.getTel() %> </td>
	</tr>
<% } %>
</table>
</body>
</html>