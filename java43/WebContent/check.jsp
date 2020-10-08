<%@page import="bean.MemberDAO"%><%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    String id = request.getParameter("id");
    MemberDAO dao = new MemberDAO();
    boolean result = dao.idCheck(id);
    String checkResultMsg;
    if(result) checkResultMsg = "able id";
    else checkResultMsg = "unable id";
%><%=checkResultMsg%>