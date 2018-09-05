<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import = "functions.Course" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>MeineKurse</title>
	<!-- Imports -->
	<div><jsp:include page="includes/imports.jsp"/></div>
</head>
<body>

<!-- Navigation and Login -->
<div><jsp:include page="includes/navigation.jsp"/></div>
	
<div class="container-fluid padding">
	<div class="row">
		<div class="col-8">
			<%
			@SuppressWarnings("unchecked")
			ArrayList<Course> list = (ArrayList<Course>) request.getAttribute("courses");
			if(!(list == null)){
			 %>
			 <%-- display the products in the table --%>
				<table>
				<tr>
					<th></th>
					<th><%out.println(list.get(0).getCourseNumber()); %></th>
					<th><%out.println(list.get(0).getDescription()); %></th>
					<th><%out.println(list.get(0).getFrequency()); %></th>
					<th><%out.println(list.get(0).getPrice()); %></th>
					<th><%out.println(list.get(0).getStudentType()); %></th>
					<th><%out.println(list.get(0).getSubject()); %></th>
					<th><%out.println(list.get(0).getTopic()); %></th>
				</tr>
				<% 		list.remove(0);
						for(Course course:list){%>
				<tr>
					<td><input type="checkbox" id="chb<%=course.getCourseNumber()%>"></td>
					<td><%out.println(course.getCourseNumber()); %></td>
					<td><%out.println(course.getDescription()); %></td>
					<td><%out.println(course.getFrequency()); %></td>
					<td><%out.println(course.getPrice()); %></td>
					<td><%out.println(course.getStudentType()); %></td>
					<td><%out.println(course.getSubject()); %></td>
					<td><%out.println(course.getTopic()); %></td>
				</tr>
				<%  	}
					}%>
		</div>
		<div class="col-4">
			<a href="KursHinzufuegen.jsp" class="col-2 nav-link">Einen Kurs hinzufügen</a>
		</div>
	</div>
</div>	
	
<!--- Meet the team -->

<div class="container-fluid padding">
	<div class="row welcome text-center padding">
		<div class="col-12">
			<h1 class="display-4">Meet the Team</h1>
		</div>
	</div>
</div>	

<!--- Cards (for the single teammembers for example) -->

<div class="container-fluid padding">
	<div class="row padding">
		<div class="col-md-3">
			<div class="card">
				<img class="card-img-top" src="img/team1.png">
				<div class="card-body">
					<h4 class="card-title">Thomas</h4>
					<p class="card-text">Product Owner</p>
					<a href="#" class="btn btn-outline-secondary">Check Profile</a>
				</div>
			</div>			
		</div>
		<div class="col-md-3">
			<div class="card">
				<img class="card-img-top" src="img/team2.png">
				<div class="card-body">
					<h4 class="card-title">David</h4>
					<p class="card-text">SCRUM-Master</p>
					<a href="#" class="btn btn-outline-secondary">Check Profile</a>
				</div>
			</div>			
		</div>
		<div class="col-md-3">
			<div class="card">
				<img class="card-img-top" src="img/team3.png">
				<div class="card-body">
					<h4 class="card-title">Marcel</h4>
					<p class="card-text">Developer</p>
					<a href="#" class="btn btn-outline-secondary">Check Profile</a>
				</div>
			</div>			
		</div>
		<div class="col-md-3">
			<div class="card">
				<img class="card-img-top" src="img/team1.png">
				<div class="card-body">
					<h4 class="card-title">Jan</h4>
					<p class="card-text">Developer</p>
					<a href="#" class="btn btn-outline-secondary">Check Profile</a>
				</div>
			</div>			
		</div>
</div>

<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>