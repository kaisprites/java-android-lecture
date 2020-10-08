<%@page import="java.util.Vector"%>
<%@page import="dbcp.ItemVO"%>
<%@page import="dbcp.ItemDAO"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	int category;
	try { //getParameter로 못 받는다고? 그럼 0이 기본값
		category = Integer.parseInt(request.getParameter("category"));
	} catch (Exception e) {
		category = 0;
	}
	String[] classPointed = new String[12];
	Arrays.fill(classPointed, "");
	classPointed[0] = "all";
	classPointed[category] = classPointed[category].concat(" pointed");
	
	String imgsrc = "https://dummyimage.com/300x200/666/fff.png&text=temp_image";
	
	ItemDAO dao = new ItemDAO();
	Vector<ItemVO> bag = dao.read();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />

<link href="css/bootstrap.min.css?after" rel="stylesheet">
<link rel="stylesheet" href="css/index.css?after" type="text/css" />
</head>
<body>
<div id="category-wrapper">
	<table id="category">
		<tr>
			<td class="<%=classPointed[0] %>" rowspan=3><a href="?category=0">전체</a></td>
			<td class="<%=classPointed[1] %>"><a href="?category=1">자연</a></td>
			<td class="<%=classPointed[2] %>"><a href="?category=2">문화</a></td> 
			<td class="<%=classPointed[3] %>"><a href="?category=3">레저</a></td>
			<td class="<%=classPointed[4] %>"><a href="?category=4">테마</a></td>
		</tr>
		<tr>
			<td class="<%=classPointed[5] %>"><a href="?category=5">섬</a></td>
			<td class="<%=classPointed[6] %>"><a href="?category=6">도보</a></td>
			<td class="<%=classPointed[7] %>"><a href="?category=7">포토스팟</a></td>
			<td class="<%=classPointed[8] %>"><a href="?category=8">사원</a></td>
		</tr>
		<tr>
			<td class="<%=classPointed[9] %>"><a href="?category=9">4.3</a></td>
			<td class="<%=classPointed[10] %>"><a href="?category=10">의료</a></td>
			<td class="<%=classPointed[11] %>"><a href="?category=11">웰빙</a></td>
			<td></td>
		</tr>
	</table>
</div>

<div id="item-container">
	<ul>
	<%
		for (int i=0; i<2; i++) {
			ItemVO vo = bag.get(i);
	%>
		<li>
			<div class="item-image"><img src="<%=imgsrc%>"></div>
			<div class="item-info-wrapper">
				<h3><%=vo.getName() %></h3>
				<h4><%=vo.getLabel1() %> > <%=vo.getLabel2() %></h4>
			</div>
			<div class="item-action-wrapper">
				<a href="#">
					<span class="item-action">
						<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span><br>
						좋아요<br>
						0
					</span>
				</a>
				<a href="#">
					<span class="item-action">
						<span class="glyphicon glyphicon-heart" aria-hidden="true"></span><br>
						찜<br>
						0
					</span>
				</a>
				<a href="#">
					<span class="item-action">
						<span class="glyphicon glyphicon-comment" aria-hidden="true"></span><br>
						리뷰<br>
						0
					</span>
				</a>
			</div>
		</li>
	<% } %>
	</ul>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js?after"></script>
<script src="js/bootstrap.min.js?after"></script>
</body>
</html>