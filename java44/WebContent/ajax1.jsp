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
	//Ư�� event ����ϴٰ� event �߻� �� �Լ� ���Ǻο��� �ڵ� ȣ���
	//���� body�� child elements�� ���� DOM-tree ����, �� �� �Լ� ����
	
	//member.xml ������ ��û�Ͽ� div������ ����ϰ�, record���� db�� ����
	$(function () {
		$('#b1').click(function() {
			$('#d1').html(" ");
			$.ajax({
				url: "data/member.xml",
				success: function (doc) {	//xml ������ ��û�ϸ� XMLDocument�� ��ȯ 
					console.log('XML ��û ����');
					console.log('XML ���: ' + doc)
					list = $(doc).find('record')	//<record></record>�� ���� �� record���� �迭��
					console.log('���ڵ� ����: '+list.length)
					if(list.length > 0) {
						$(list).each(function(idx, item) {
							//�� attribute���� ������ string���� ����� ���
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
							
							//db�� ����
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
									if(result == "true") console.log("db �Է� ��û �Ϸ�")
									
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
<button id="b1">xml ��û</button>
<button id="b2">json ��û</button>
<button id="b3">db�� ����</button>
<div id="d1"></div>
</body>
</html>