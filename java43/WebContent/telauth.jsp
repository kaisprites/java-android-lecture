<%@page import="java.util.Random"%><%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    /* 전화번호를 전달받아, 전화번호 길이가 10 이하이거나 01로 시작하지 않으면 에러 메시지 출력, 그렇지 않은 경우 인증번호 반환 */
    String tel = request.getParameter("tel");
    StringBuffer a = new StringBuffer();
    String code = tel.substring(0,3);
    if(tel.length() < 10 || !tel.substring(0,2).equals("01") ) a.append("올바른 전화번호를 입력하시오");
    else {
	    Random r = new Random();
	    a.append("인증번호: ");
	    a.append(r.nextInt(90)+10);
	    a.append(code);
	    a.append(r.nextInt(10));
    }
    %><%=a%>