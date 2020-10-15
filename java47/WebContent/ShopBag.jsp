<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- 쇼핑백장바구니의구현 -->
<h1>장바구니에넣기</h1>
<form action="add.jsp">
	<select name="product">
		<option value ="watch"> 시계</option>
		<option value="ballpen">볼펜</option>
		<option value="notebook">노트북</option> 
	</select>
	<select name="price">
		<option value ="10000">10000원</option>
		<option value="20000">20000원</option>
		<option value="30000">30000원</option> 
	</select>
<button type="submit">장바구니에 넣기</button>
</form>
</body>
</html>