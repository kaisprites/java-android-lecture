<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	//��Ű 3���� �����ؼ� Ŭ���̾�Ʈ�� �ɾ
	Cookie c1 = new Cookie("fruit", "apple");
	Cookie c2 = new Cookie("study", "spring");
	Cookie c3 = new Cookie("tour", "local");
	response.addCookie(c1);
	response.addCookie(c2);
	response.addCookie(c3);
%>
<a href="cookietaker.jsp">��Ű���뺸��</a>
</body>
</html>