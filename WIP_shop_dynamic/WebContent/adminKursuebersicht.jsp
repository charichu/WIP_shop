<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import = "courseFunctions.Course" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Kursübersicht</title>
	<!-- Imports -->
	<div><jsp:include page="includes/imports.jsp"/></div>
</head>
<body>

<!-- Admin-Navigation with servlet call-->
<div><jsp:include page="includes/adminNavigation.jsp"/></div>	
	<div id = "wrapper" class="row">
		
		<!-- admin content -->
		<div id = "adminContent" class="col-8">
		
		<%--get attribute from request, which is set in the servlet --%>
		<%
			ArrayList<Course> list = (ArrayList<Course>) request.getAttribute("courses");
			if(!(list == null)){
		 %>
		 <%-- display the products in the table --%>
			<table>
			<tr>
				<th></th>
				<th><%out.println(list.get(0).getCourseNumber()); %></th>
				<th><%out.println(list.get(0).getSubject()); %></th>
				<th><%out.println(list.get(0).getTopic()); %></th>
				<th><%out.println(list.get(0).getGrade()); %></th>
				<th><%out.println(list.get(0).getDescription()); %></th>
				<th><%out.println(list.get(0).getFrequency()); %></th>
				<th><%out.println(list.get(0).getStudentType()); %></th>
				<th><%out.println(list.get(0).getPricePerHour()); %></th>

			</tr>
			<% 		list.remove(0);
					for(Course course:list){%>
			<tr>
				<td><input type="checkbox" name="chbSelectCourse" value="chb<%=course.getCourseNumber()%>"></td>
				<td><%out.println(course.getCourseNumber()); %></td>
				<td><%out.println(course.getSubject()); %></td>
				<td><%out.println(course.getTopic()); %></td>
				<td><%out.println(list.get(0).getGrade()); %></td>
				<td><%out.println(course.getDescription()); %></td>
				<td><%out.println(course.getFrequency()); %></td>
				<td><%out.println(course.getStudentType()); %></td>
				<td><%out.println(course.getPricePerHour()); %></td>
			</tr>
			<%  	}
				}%>
			</table>
			
		</div>
		
		<!-- admin functions -->
		<div id="adminFunctions" class="col-4">
			<table>
				<tr>
					<td>
						<form  action="CreateCourse" method="get">
							<input type="submit" class="nav-link" id = "createCourse" value="Neuen Kurs erstellen">
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<form  action="" method="get">
							<input type="submit" class="nav-link" id = "changeCourse" value="Ändern">
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<form  action="" method="get">
							<input type="submit" class="nav-link" id = "showCourse" value="Anzeigen">
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<form  action="" method="get">
							<input type="submit" class="nav-link" id = "deleteCourse" value="Löschen">
						</form>
					</td>
					
				</tr>
			</table>
		</div>
	</div>
	
</body>


</html>

