<%@page import="java.util.Random"%><%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    /* ��ȭ��ȣ�� ���޹޾�, ��ȭ��ȣ ���̰� 10 �����̰ų� 01�� �������� ������ ���� �޽��� ���, �׷��� ���� ��� ������ȣ ��ȯ */
    String tel = request.getParameter("tel");
    StringBuffer a = new StringBuffer();
    String code = tel.substring(0,3);
    if(tel.length() < 10 || !tel.substring(0,2).equals("01") ) a.append("�ùٸ� ��ȭ��ȣ�� �Է��Ͻÿ�");
    else {
	    Random r = new Random();
	    a.append("������ȣ: ");
	    a.append(r.nextInt(90)+10);
	    a.append(code);
	    a.append(r.nextInt(10));
    }
    %><%=a%>