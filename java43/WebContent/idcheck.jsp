<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    String id = request.getParameter("id");
    MemberDAO dao = new MemberDAO();
    boolean result = dao.idCheck(id);
    String text = "�ߺ��� id�Դϴ�";
    if(result) text = "��밡���� id�Դϴ�"; 
%><%=text%>