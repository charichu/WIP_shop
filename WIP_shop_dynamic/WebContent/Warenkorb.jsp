<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import = "functions.Course" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Warenkorb</title>
	<!-- Imports -->
	<div><jsp:include page="includes/imports.jsp"/></div>
	<div><jsp:include page="includes/scripts.jsp"/></div>
</head>
<body>

<!-- Navigation and Login -->
<div><jsp:include page="includes/navigation.jsp"/></div>	

<div class="container-fluid padding">
	<div class="row welcome text-center padding">
		<div class="col-8">
			<% if(request.getAttribute("successMessage")!=null){%>
				<div id="alert_message" class="alert alert-success" role="alert">
				  <% out.println(request.getAttribute("successMessage")); %>
				</div>
			<%	}%>
			<% if(request.getAttribute("errorMessage")!=null){%>
				<div id="alert_message" class="alert alert-error" role="alert">
				  <% out.println(request.getAttribute("errorMessage")); %>
				</div>
			<%	}%>
			<h1 class="display-4">Warenkorb</h1>
			<%
			ArrayList<Course> list = (ArrayList<Course>) request.getAttribute("cart");
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
					<th><%out.println(list.get(0).getPrice()); %></th>
	
				</tr>
				<% 		list.remove(0);
						for(Course course:list){%>
				
				<tr>
					
						<td><input type="checkbox" name="chbSelectCourse" value="chb<%=course.getCourseNumber()%>"></td>
						<td><%out.println(course.getCourseNumber()); %></td>
						<td><%out.println(course.getSubject()); %></td>
						<td><%out.println(course.getTopic()); %></td>
						<td><%out.println(course.getGrade()); %></td>
						<td><%out.println(course.getDescription()); %></td>
						<td><%out.println(course.getFrequency()); %></td>
						<td><%out.println(course.getStudentType()); %></td>
						<td><%out.println(course.getPrice()); %></td>
						<td><a class="nav-link" href="DisplayDetails?courseID=<%=course.getCourseNumber()%>">Details</a></td>
						<td><form action="DeleteCourseFromCart">
								<input type="submit" value="löschen">
								<input type="hidden" name="courseID" value="<%=course.getCourseNumber()%>">
							</form></td>
				</tr>
			<%  		}
			}
			else{%>
				Ihr Warenkorb wurde nicht befüllt.
			<%
			}%>
			</table>
		</div class="col-4">
			
		<div>
		</div>
	</div>
</div>	
<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>