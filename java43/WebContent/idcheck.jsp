<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    String id = request.getParameter("id");
    MemberDAO dao = new MemberDAO();
    boolean result = dao.idCheck(id);
    String text = "중복된 id입니다";
    if(result) text = "사용가능한 id입니다"; 
%><%=text%>