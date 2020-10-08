<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    String id = request.getParameter("id");
    String result = "<font color=red>id는 최소 5글자 이상 입력하세요</font>";
    if(id.length()>=5) result = "<font color=green>유효한 id입니다</font>";
    %><%=result%>