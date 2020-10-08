<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    String pw = request.getParameter("pw");
    String pw2 = request.getParameter("pw2");
    
    String result = "<font color=red>패스워드가 일치하지 않습니다</font>";
    if (pw.equals("") && pw2.equals("")) result = "<font color=red>패스워드를 입력하세요</font>";
    else if (pw.equals(pw2)) result = "<font color=green>패스워드 확인 완료</font>";
    %><%=result%>