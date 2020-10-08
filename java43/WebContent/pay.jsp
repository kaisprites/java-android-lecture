<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    String price = request.getParameter("price");
    String paytype = request.getParameter("paytype");
    
    %><%
    if(price.length()==0) {
    	%>결제금액을 입력하세요<%
    } else if(paytype == null) {
    	%>결제수단을 선택하세요<%
    } else {
    %>결제금액: <%=price%>
결제방식: <%=paytype%><% } %> 