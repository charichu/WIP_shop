<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%! String nav = "includes/start.jsp"; %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Responsives meta tags, User Zoom nicht erlaubt -->
<meta name="viewport" content="width=device-width, inital-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!--  Script für Responsivität -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
$("#nav ul li a").addclass('active');
</script>

<title>Masterpage</title>
<link href = "style.css" rel = "stylesheet">
</head>
<body>
	<div id = "wrapper">
		<jsp:include page="includes/header.jsp"/>
		<div id= "websiteContent">
		Startseite
			<!--  <article> Startseite </article> -->
		</div>
		<jsp:include page="includes/footer.jsp"/>
	</div>
</body>
</html>

