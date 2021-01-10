<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String pwr = request.getParameter("pwr");
	String text = "로그인되었습니다";
	if(!pw.equals(pwr)) text = "입력한 두 비밀번호가 다릅니다";
	else {
		MemberDAO dao = new MemberDAO();
		boolean result = dao.login(id, pw);
		if(!result) text = "로그인에 실패하였습니다"; 
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=text%>
</body>
</html>