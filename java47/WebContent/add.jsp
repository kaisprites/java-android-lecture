<%@page import="java47.BasketVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%
    String product = request.getParameter("product");
    String price = request.getParameter("price");
    ArrayList<BasketVO> list = null;
    if(session.getAttribute("basket") != null) {
    	// TODO IF ��ٱ��ϰ� ������� �ִٸ�
    	// ������ �ִ� �������� ��Ƶ� ��ٱ��� ����� ������ �ͼ�
    	// ���ο� product add
    	list = (ArrayList<BasketVO>)session.getAttribute("basket");
    }else{
    	// TODO IF ��ٱ��ϰ� ���ٸ�
    	// ��ٱ��� ���� ���� ���ο� product add
    	list = new ArrayList<> ();
    }
    //�Ķ���ͷ� VO ���� list�� add
	if(product != null) {
		BasketVO vo = new BasketVO();
		vo.setProduct(product);
		vo.setPrice(price);
		System.out.println(vo);
		list.add(vo);
	}
    //list�� session�� ����
    session.setAttribute("basket", list) ;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>��ٱ��� ���</h3>
<hr color="blue">
<%
	for(BasketVO vo : list) {
%>
	<%=vo.getProduct() %>: <%=vo.getPrice() %>��<br>
<%
	}
%>
<hr color="blue">
<a href="ShopBag.jsp">���ֱ�</a>
<a href="null.jsp">��ٱ��������</a>
</body>
</html>