<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    //ReplyDAO로 reply 저장
    //성공하면 저장 데이터를 전송
    String reply = request.getParameter("reply");
    
    String result = "-" + reply + "<br>";
    %><%=result%>