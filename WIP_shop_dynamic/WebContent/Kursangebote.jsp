<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import = "courseFunctions.Course" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Kursangebote</title>
	<!-- Imports -->
	<div><jsp:include page="includes/imports.jsp"/></div>
	<div><jsp:include page="includes/scripts.jsp"/></div>
</head>
<body>

<!-- Navigation and Login -->
<div><jsp:include page="includes/navigation.jsp"/></div>
<nav class="navbar navbar-expand-md navbar-light bg-light">
	<div class="container-fluid">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<!-- id and class for the navbar -->
		<div class="collapse navbar-collapse" id="navbarResponsive">
			
			<!-- ml pushes the navigation to the right side when it is in full width -->
			<ul class="navbar-nav ml-auto">
				<li class="nav-item">
					<form action="">
						<input type="submit" name="dummy" value="Dummy">
					</form>
				</li>	
				<li class="nav-item">
					<form action="">
						<input type="submit" name="dummy" value="Dummy">
					</form>
				</li>	
				<li class="nav-item">
					<form action="">
						<input type="submit" name="dummy" value="Dummy">
					</form>
				</li>	
			</ul>
		</div>
	</div>
</nav>

<!--- Show Courses -->

<div class="container-fluid padding">
	<div class="row welcome text-center padding">
		<div class="col-12">
			<% if(request.getAttribute("successMessage")!=null){%>
				<div id="alert_message" class="alert alert-success" role="alert">
				  <% out.println(request.getAttribute("successMessage")); %>
				</div>
			<%	}%>
			<h1 class="display-4">Kursangebote</h1>
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
				</tr>
				<%  	}
					}%>
			</table>
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

<!---  Contact Second Two Column Section  -->

<div class="container-fluid padding">
	<div class="row padding">
		<!-- first column -->
		<div class="col-lg-6">
			<h2>Contact us here</h2>
			<p>Paragraph 3, apparently. The image can be the placeholder for a contact formular.</p>
			
		</div>
		<!-- second column -->
		<div class="col-lg-6">
			<img src="img/bootstrap2.png" class="img-fluid">
		</div>
	</div>
	<!-- Horizontal rule again -->
	<hr class="my-4">
</div>	

<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>