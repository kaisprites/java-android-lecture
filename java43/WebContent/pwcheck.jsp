<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    String pw = request.getParameter("pw");
    String pw2 = request.getParameter("pw2");
    
    String result = "<font color=red>�н����尡 ��ġ���� �ʽ��ϴ�</font>";
    if (pw.equals("") && pw2.equals("")) result = "<font color=red>�н����带 �Է��ϼ���</font>";
    else if (pw.equals(pw2)) result = "<font color=green>�н����� Ȯ�� �Ϸ�</font>";
    %><%=result%>