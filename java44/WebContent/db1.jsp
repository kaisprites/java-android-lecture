<%@page import="bean.MemberVO2"%><%@page import="bean.MemberDAO2"%><%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    MemberDAO2 dao = new MemberDAO2();
    MemberVO2 vo = new MemberVO2();
    vo.setId(Integer.parseInt(request.getParameter("id")));
    vo.setFirst_name(request.getParameter("first_name"));
    vo.setLast_name(request.getParameter("last_name"));
    vo.setEmail(request.getParameter("email"));
    vo.setGender(request.getParameter("gender"));
    vo.setIp_address(request.getParameter("ip_address"));
    boolean result = dao.create(vo);
    %><%=result%>