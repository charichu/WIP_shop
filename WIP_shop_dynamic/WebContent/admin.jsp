<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Adminseite</title>
	<!-- Imports -->
	<div><jsp:include page="includes/imports.jsp"/></div>
</head>
<body>

<!-- Admin-Navigation with servlet call-->
<div><jsp:include page="includes/adminNavigation.jsp"/></div>

<!-- Admin-home content-->	
	<div id = "wrapper">
		<div id = "adminContent">
		 <% session.setAttribute("Name", "Name"); %>
		</div>
	</div>

	
</body>


</html>

