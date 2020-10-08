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
			$('#d1').html(" ");
			$.ajax({
				url: "data/member.xml",
				success: function (doc) {	//xml 문서를 요청하면 XMLDocument를 반환 
					console.log('XML 요청 성공');
					console.log('XML 결과: ' + doc)
					list = $(doc).find('record')	//<record></record>로 묶인 각 record들을 배열로
					console.log('레코드 개수: '+list.length)
					if(list.length > 0) {
						$(list).each(function(idx, item) {
							//각 attribute들의 내용을 string으로 만들어 출력
							id = $(item).find('id').text()
							first_name = $(item).find('first_name').text()
							last_name = $(item).find('last_name').text()
							email = $(item).find('email').text()
							gender = $(item).find('gender').text()
							ip_address = $(item).find('ip_address').text()
							recordText = first_name + " "
									   + last_name + " "
									   + email + " "
									   + gender + " "
									   + ip_address + "<br>"
							$('#d1').append(recordText);
							
							//db에 전송
							$.ajax({
								url: "db1.jsp",
								data: {
									id: id,
									first_name: first_name,
									last_name: last_name,
									email: email,
									gender: gender,
									ip_address: ip_address
								},
								success: function(result) {
									if(result == "true") console.log("db 입력 요청 완료")
									
								}
							})
						})
					}
				}
			})
		})
		$('#b2').click(function() {
			$.ajax({
				url: "data/member.json",
				success: function (list) {
					console.log(list);
					console.log(list[0]);
					console.log(list[0]['id']);
					list.forEach((item,idx)=>{
						id = item['id']
						first_name = item['first_name']
						last_name = item['last_name']
						email = item['email']
						gender = item['gender']
						ip_address = item['ip_address']
						recordText = first_name + " "
								   + last_name + " "
								   + email + " "
								   + gender + " "
								   + ip_address + "<br>"
						$('#d1').append(recordText);
					})
				}
			})
		})
		$('#b3').click(function() {
			$.ajax({
				url: "data/db1.jsp",
				success: function () {
					
				}
			})
		})
	})
</script>
</head>
<body>
<button id="b1">xml 요청</button>
<button id="b2">json 요청</button>
<button id="b3">db에 삽입</button>
<div id="d1"></div>
</body>
</html>