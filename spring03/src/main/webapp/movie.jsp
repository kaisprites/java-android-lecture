<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserts title here</title>
<link rel="stylesheet" href="resources/css/movie.css"  />
<script
  src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
	$(function(){
		//alert("환영합니다!.!..!")
		$('#b1').click(function() {
			replyValue = $('#reply').val()
			replyHistory = $('#d1').html()
			$.ajax({
				url: "reply",
				data: {
				reply: replyValue,
				history: replyHistory
				},
				success: function(result) {
					$('#d1').html(result);
					$('#reply').val('');
				}
			})
		})
		
		$('#id').keyup(function() {
			id = $('#id').val()
			$.ajax({
				url: "idcheck",
				data: {
					id: id
				},
				success: function(result) {
					$('#d2').html(result);
				}
			})
		})
	});
</script>
</head>
<body>
	<form action="movie" method="post">
		<p><input type="text" name="title" placeholder="영화제목"></p>
		<p><input type="text" name="price" placeholder="영화관람료"></p>
		<button>전송</button>
	</form>
	<hr color="red">
	<p><input type="text" id="reply" placeholder="reply"></p>
	<button id="b1">reply</button>
	<hr color="blue">
	<div id="d1"></div>
	<hr color="darkgreen">
	<p><input type="text" id="id" placeholder="id"></p>
	<div id="d2"></div>
</body>
</html>