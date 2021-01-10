<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.MemberDAO" %>
<!-- 
	1. get submitted data of client
	2. make sql and submit to db
	3. get result and submit html to client
 -->
 <%
 	//HttpServletRequest request = 
 	String id = request.getParameter("id");
 	String pw = request.getParameter("pw");
	//auto import: ctrl+shift+m on current class
	MemberDAO dao = new MemberDAO();
	boolean result = dao.read(id, pw);
	String check = "false";
	if(result) {
		check="true";
	}
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 style="color:red">your input data result is <%=check %></h3>
<hr color="red">
id: <% out.print(id); %><br>
pw: <%=pw %><br> <!-- expression -->
<hr color="blue">
<a href="login.html">login page</a>
</body>
</html>