<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    String price = request.getParameter("price");
    String paytype = request.getParameter("paytype");
    
    %><%
    if(price.length()==0) {
    	%>�����ݾ��� �Է��ϼ���<%
    } else if(paytype == null) {
    	%>���������� �����ϼ���<%
    } else {
    %>�����ݾ�: <%=price%>
�������: <%=paytype%><% } %> 