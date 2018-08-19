<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Masterpage</title>
<link href = "style.css" rel = "stylesheet">
</head>
<body>
	<div id = "wrapper">
		<%@include file="includes/header.jsp" %>
		
		<div id= "websiteContent">
			Hier kommt der Inhalt der einzelnen Unterseiten rein.
		</div>
		
		<%@include file="includes/footer.jsp" %>
	</div>
</body>
</html>