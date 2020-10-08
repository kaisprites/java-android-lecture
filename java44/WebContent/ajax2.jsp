<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript">
	//callback function
	//특정 event 대기하다가 event 발생 시 함수 정의부에서 자동 호출됨
	//먼저 body의 child elements에 대해 DOM-tree 구성, 그 후 함수 정의
	
	//member.xml 문서를 요청하여 div영역에 출력하고, record들을 db에 삽입
	$(function () {
		$('#b1').click(function() {
			$('#d1').html("")
			$.ajax({
				url: "https://api.rss2json.com/v1/api.json",
				data: {
					rss_url:"http://health.chosun.com/site/data/rss/rss.xml",
					api_key:"e4dpa8ipughfunksdxqbjs4owqct0gc3nyhsmbyp",
					count:30
				},
				success: function(result) {
					a = result;	
					console.log('성공!!' + result);
					list = result.items
					console.log(list.length)
					if(list.length > 0) {
						$(list).each(function(index, news) {
							$('#d1').append(this.title + "<br>")
							$('#d1').append(this.pubDate + "<br>")
							$('#d1').append("<a href=" + this.link + ">" + this.link + "</a><br><hr>")
						})
					}
				}
			})
		})
		$('#b2').click(function() {
			$('#d1').html("")
			$.ajax({
				url: "https://api.rss2json.com/v1/api.json",
				data: {
					rss_url:"http://travel.chosun.com/site/data/rss/rss.xml",
					api_key:"e4dpa8ipughfunksdxqbjs4owqct0gc3nyhsmbyp",
					count:30
				},
				success: function(result) {
					a = result;	
					console.log('성공!!' + result);
					list = result.items
					console.log(list.length)
					if(list.length > 0) {
						$(list).each(function(index, news) {
							$('#d1').append(this.title + "<br>")
							$('#d1').append(this.pubDate + "<br>")
							$('#d1').append(this.description + "<br>")
							$('#d1').append("<a href=" + this.link + ">" + this.link + "</a><br><hr>")
						})
					}
				}
			})
		})
		$('#b3').click(function() {
			$('#d1').html("")
			$.ajax({
				url: "https://api.rss2json.com/v1/api.json",
				data: {
					rss_url:"http://art.chosun.com/site/data/rss/rss.xml",
					api_key:"e4dpa8ipughfunksdxqbjs4owqct0gc3nyhsmbyp",
					count:30
				},
				success: function(result) {
					a = result;	
					console.log('성공!!' + result);
					list = result.items
					console.log(list.length)
					if(list.length > 0) {
						$(list).each(function(index, news) {
							$('#d1').append(this.title + "<br>")
							$('#d1').append(this.pubDate + "<br>")
							$('#d1').append("<a href=" + this.link + ">" + this.link + "</a><br><hr>")
						})
					}
				}
			})
		})
		$('#b4').click(function() {
			$('#d1').html("")
			$.ajax({
				url: "https://api.rss2json.com/v1/api.json",
				data: {
					rss_url:"http://rss.hankyung.com/new/news_enter.xml",
					api_key:"e4dpa8ipughfunksdxqbjs4owqct0gc3nyhsmbyp",
					count:30
				},
				success: function(result) {
					a = result;	
					console.log('성공!!' + result);
					list = result.items
					console.log(list.length)
					if(list.length > 0) {
						$(list).each(function(index, news) {
							$('#d1').append(this.title + "<br>")
							$('#d1').append(this.pubDate + "<br>")
							$('#d1').append("<a href=" + this.link + ">" + this.link + "</a><br><hr>")
							
							
							$.ajax({
								url: "db2.jsp",
								data: {
									title: this.title,
									pubDate: this.pubDate,
									link: this.link
								},
								success: function(result) {
									console.log(result);
								}
							})
						})
					}
				}
			})
		})
		$('#b5').click(function() {
			$('#d1').html("")
			$.ajax({
				url: "https://api.rss2json.com/v1/api.json",
				data: {
					rss_url:"http://rss.hankyung.com/new/news_photo.xml",
					api_key:"e4dpa8ipughfunksdxqbjs4owqct0gc3nyhsmbyp",
					count:30
				},
				success: function(result) {
					a = result;	
					console.log('성공!!' + result);
					list = result.items
					console.log(list.length)
					if(list.length > 0) {
						$(list).each(function(index, news) {
							$('#d1').append(this.title + "<br>")
							$('#d1').append(this.pubDate + "<br>")
							$('#d1').append("<a href=" + this.link + ">" + this.link + "</a><br><hr>")
						})
					}
				}
			})
		})
	})
</script>
</head>
<body>
<button id="b1">조선헬스.rss 요청</button>
<button id="b2">조선트래블.rss 요청</button>
<button id="b3">조선아트.rss 요청</button>
<button id="b4">한경연예.rss 요청</button>
<button id="b5">한경포토.rss 요청</button>
<div id="d1"></div>
</body>
</html>