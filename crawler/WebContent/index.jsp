<%@page import="crawler.StringExtractor"%>
<%@ page import="org.jsoup.Jsoup" %>
<%@ page import="org.jsoup.nodes.Document" %>
<%@ page import="org.jsoup.nodes.Element" %>
<%@ page import="org.jsoup.select.Elements" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script>
</script>
</head>
<body>
<% 
	String[] domain = {"https://www.visitjeju.net/kr/detail/view?contentsid=CNTS_200000000010699",
					   "https://www.visitjeju.net/kr/detail/view?contentsid=CONT_000000000500349"};
						
	for (int i=0; i<2; i++) {
		Document doc2 = Jsoup.connect(domain[i]).get();
		String data = doc2.data();
		data = data.replace("\\u003C","<");
		data = data.replace("\\u003E",">");
		data = data.replace("\\u002F","/");
		
		String namesub = StringExtractor.extractor("\"kr\":\"", data);
		String name = StringExtractor.extractor("", "\",\"", namesub);
		String body = StringExtractor.extractor("{\"body\":\"<p><br></p><p>", "\"},\"children\":[]}]}]}", data);
		String address = StringExtractor.extractor("\\\"address\\\":\\\"", "\\\",\\\"roadaddress", data);
		String keyword = StringExtractor.extractor("keywordseo\\\":\\\"", "\\\",\\\"langservice", data);
		String tel = StringExtractor.extractor("phoneno\\\":\\\"", "\\\",\\\"latitude", data);
		String lat = StringExtractor.extractor("latitude\\\":", ",\\\"longitude\\\":", data); 
		String lng = StringExtractor.extractor(",\\\"longitude\\\":", ",\\\"editordesc", data);
		String label1 = StringExtractor.extractor("region2\\\",\\\"label\\\":\\\"", "\\\",\\\"refId\\\":\\\"region", data);
		String label2sub = StringExtractor.extractor("region2cd", "\\\",\\\"refId\\\":\\\"region2", data);
		String label2 = StringExtractor.extractor("label\\\":\\\"", label2sub);
%>
<p>품명: <%=name %></p>
<p>내용: <%=body %></p>
<p>주소: <%=address %></p>
<p>키워드: <%=keyword %></p>
<p>전화번호: <%=tel %></p>
<p>위치: <%=lat %>, <%=lng %></p>
<p>레이블: <%=label1 %> > <%=label2 %></p>
<% } %>

</body>
</html>