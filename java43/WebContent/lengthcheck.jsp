<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    String id = request.getParameter("id");
    String result = "<font color=red>id�� �ּ� 5���� �̻� �Է��ϼ���</font>";
    if(id.length()>=5) result = "<font color=green>��ȿ�� id�Դϴ�</font>";
    %><%=result%>