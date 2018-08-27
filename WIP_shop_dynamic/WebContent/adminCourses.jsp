<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import = "functions.Course" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Adminseite</title>
	<!-- Imports -->
	<div><jsp:include page="includes/imports.jsp"/></div>
</head>
<body>

<!-- Admin-Navigation -->
<div><jsp:include page="includes/adminNavigation.jsp"/></div>	
	<div id = "wrapper">
		<div id = "adminContent">
		
		<%--get attribute from request, which is set in the servlet --%>
		<%
			ArrayList<Course> list = (ArrayList<Course>) request.getAttribute("courses");
		 %>
			<table>
			<tr>
				<th><%out.println(list.get(0).getCouseNumber()); %></th>
				<th><%out.println(list.get(0).getDescription()); %></th>
				<th><%out.println(list.get(0).getFrequency()); %></th>
				<th><%out.println(list.get(0).getPrice()); %></th>
				<th><%out.println(list.get(0).getStudentType()); %></th>
				<th><%out.println(list.get(0).getSubject()); %></th>
				<th><%out.println(list.get(0).getTopic()); %></th>
			</tr>
			<% 	list.remove(0);
				for(Course course:list){%>
			<tr>
				<td><%out.println(course.getCouseNumber()); %></td>
				<td><%out.println(course.getDescription()); %></td>
				<td><%out.println(course.getFrequency()); %></td>
				<td><%out.println(course.getPrice()); %></td>
				<td><%out.println(course.getStudentType()); %></td>
				<td><%out.println(course.getSubject()); %></td>
				<td><%out.println(course.getTopic()); %></td>
			</tr>
			<% } %>
			</table>
			
		</div>
	</div>
<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

	
</body>


</html>

