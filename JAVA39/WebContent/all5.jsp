<%@page import="bean.BBSVO"%>
<%@page import="bean.BBSDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String title = request.getParameter("title");
    	String content = request.getParameter("content");
    	BBSDAO dao = new BBSDAO();
    	List<BBSVO> list = dao.search(title, content);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 style=color:blue>검색결과의 개수: <%= list.size() %>개</h3>
<table>
	<tr>
		<td> no </td>
		<td> title </td>
		<td> writer </td>
		<td> content </td>
	</tr>
<% for(int i = 0; i < list.size(); i++) {
	BBSVO vo = list.get(i);%>
	<tr>
		<td> <%= vo.getNo() %> </td>
		<td> <%= vo.getTitle() %> </td>
		<td> <%= vo.getWriter() %> </td>
		<td> <%= vo.getContent() %> </td>
	</tr>
<% } %>
</table>
</body>
</html>