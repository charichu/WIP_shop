<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import = "courseFunctions.Course" %>
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
<div><jsp:include page="includes/scripts.jsp"/></div>
	
<div class="container-fluid padding">
	<div class="row">
		<div class="col-8">
			<%
			boolean userLoggedIn = (Boolean)session.getAttribute("userLoggedIn");
			Integer userType     = (Integer)session.getAttribute("userType");
			ArrayList<Course> list = (ArrayList<Course>) request.getAttribute("myCourses");
			if(list != null){
			%>
			<%-- display the products in the table --%>
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
			<table>
				<tr>
					<th><%out.println(list.get(0).getCourseNumber()); %></th>
					<th><%out.println(list.get(0).getSubject()); %></th>
					<th><%out.println(list.get(0).getGrade()); %></th>
					<th><%out.println(list.get(0).getDescription()); %></th>
					<th><%out.println(list.get(0).getFrequency()); %></th>
					<th><%out.println(list.get(0).getStudentType()); %></th>
					<th><%out.println(list.get(0).getPricePerHour()); %></th>
	
				</tr>
				<% 		list.remove(0);
						for(Course course:list){%>
				
				<tr>
					
						<td><%out.println(course.getCourseNumber()); %></td>
						<td><%out.println(course.getSubject()); %></td>
						<td><%out.println(course.getGrade()); %></td>
						<td><%out.println(course.getDescription()); %></td>
						<td><%out.println(course.getFrequency()); %></td>
						<td><%out.println(course.getStudentType()); %></td>
						<td><%out.println(course.getPricePerHour()); %></td>
						<td><a class="nav-link" href="DisplayCourseDetails?courseID=<%=course.getCourseNumber()%>">Details</a></td>
						<%if(userLoggedIn&&userType!=2){  %>
							<td><a class="nav-link" href="GetEditCourse?courseID=<%=course.getCourseNumber()%>">Bearbeiten</a></td>
							<td>
								<form action="DeleteCourse" method="post">
									<input type="submit" value="löschen">
									<input type="hidden" name="courseID" value="<%=course.getCourseNumber()%>">
									<input type="hidden" name="target" value="GetMyCourses">
								</form>
							</td>
						<%} %>
				</tr>
				<%  	}
					}%>
			</table>
		</div>
		<div class="col-4">
			<%if(userLoggedIn&&userType!=2){  %>
				<a href="KursHinzufuegen.jsp" class="btn btn-secondary">Einen Kurs hinzufügen</a>
			<%} %>
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