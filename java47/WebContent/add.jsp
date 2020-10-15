<%@page import="java47.BasketVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    String product = request.getParameter("product");
    String price = request.getParameter("price");
    ArrayList<BasketVO> list = null;
    if(session.getAttribute("basket") != null) {
    	// TODO IF 장바구니가 만들어져 있다면
    	// 기존에 있던 세션으로 잡아둔 장바구니 목록을 가지고 와서
    	// 새로운 product add
    	list = (ArrayList<BasketVO>)session.getAttribute("basket");
    }else{
    	// TODO IF 장바구니가 없다면
    	// 장바구니 새로 만들어서 새로운 product add
    	list = new ArrayList<> ();
    }
    //파라미터로 VO 만들어서 list에 add
	if(product != null) {
		BasketVO vo = new BasketVO();
		vo.setProduct(product);
		vo.setPrice(price);
		System.out.println(vo);
		list.add(vo);
	}
    //list를 session에 재등록
    session.setAttribute("basket", list) ;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>장바구니 목록</h3>
<hr color="blue">
<%
	for(BasketVO vo : list) {
%>
	<%=vo.getProduct() %>: <%=vo.getPrice() %>원<br>
<%
	}
%>
<hr color="blue">
<a href="ShopBag.jsp">더넣기</a>
<a href="null.jsp">장바구니지우기</a>
</body>
</html>