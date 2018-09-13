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
		<div id = "adminContent" class="col-10">
		
		<%--get attribute from request, which is set in the servlet --%>
		<%
			ArrayList<Course> list = (ArrayList<Course>) request.getAttribute("courses");
			if(!(list == null)){
		 %>
		 <%-- display the products in the table --%>
			<table class="table table-striped">
			<tr>
				<th><%out.println(list.get(0).getCourseNumber()); %></th>
				<th><%out.println(list.get(0).getSubject()); %></th>
				<th><%out.println(list.get(0).getTopic()); %></th>
				<th><%out.println(list.get(0).getGrade()); %></th>
				<th><%out.println(list.get(0).getDescription()); %></th>
				<th><%out.println(list.get(0).getFrequency()); %></th>
				<th><%out.println(list.get(0).getStudentType()); %></th>
				<th><%out.println(list.get(0).getPricePerHour()); %></th>
				<th>gelöscht</th>

			</tr>
			<% 		list.remove(0);
					for(Course course:list){%>
			<tr>
				<td><%out.println(course.getCourseNumber()); %></td>
				<td><%out.println(course.getSubject()); %></td>
				<td><%out.println(course.getTopic()); %></td>
				<td><%out.println(list.get(0).getGrade()); %></td>
				<td><%out.println(course.getDescription()); %></td>
				<td><%out.println(course.getFrequency()); %></td>
				<td><%out.println(course.getStudentType()); %></td>
				<td><%out.println(course.getPricePerHour()); %></td>
				<td>
					<%if(course.isActive()){
						out.println("Nein");
					  }
					  else{
						out.println("Ja");
					  }
					%>
				</td>
				<td><a class="nav-link" href="DisplayCourseDetailsAdmin?courseID=<%=course.getCourseNumber()%>">Details</a></td>

				<%if(course.isActive()){%>
					<td><a class="nav-link" href="GetEditCourseAdmin?courseID=<%=course.getCourseNumber()%>">Bearbeiten</a></td>
					<td>
						<form action="DeleteCourse" method="post">
							<input type="submit" value="löschen">
							<input type="hidden" name="courseID" value="<%=course.getCourseNumber()%>">
							<input type="hidden" name="target" value="/GetCourses?targetSite=%2FadminKursuebersicht.jsp">
						</form>
					</td>
				<%} %>
			</tr>
			<%  	}
				}%>
			</table>
			
		</div>
		
		<!-- admin functions -->
		<div id="adminFunctions" class="col-2">
			<table>
				<tr>
					<td>
						<a href="KursHinzufuegen.jsp">Neuen Kurs erstellen</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	
</body>


</html>

