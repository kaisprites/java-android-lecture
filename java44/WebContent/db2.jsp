<%@page import="bean.NewsVO"%><%@page import="bean.NewsDAO"%><%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    NewsDAO dao = new NewsDAO();
    NewsVO vo = new NewsVO();
    vo.setTitle(request.getParameter("title"));
    vo.setPubdate(request.getParameter("pubDate"));
    vo.setLink(request.getParameter("link"));
    boolean result = dao.create(vo);
    %><%=result%>