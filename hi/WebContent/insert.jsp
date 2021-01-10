<%@page import="bean.MemberVO"%>
<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	
	MemberDAO dao = new MemberDAO();
	MemberVO vo = new MemberVO();
	vo.setId(id);
	vo.setPw(pw);
	vo.setName(name);
	vo.setTel(tel);
	dao.create(vo);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>submitted data</p>
<p>id: <%=id %></p>
<p>pw: <%=pw %></p>
<p>name: <%=name %></p>
<p>tel: <%=tel %></p>
</body>
</html>