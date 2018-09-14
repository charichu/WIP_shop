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
	
<div class="container-fluid padding centered">
	<div class="row centered">
		<div class="col-12" style="overflow:auto">
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
			<div class="table-responsive">
				<table class="table table-striped">
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
			
		</div>
		<div class="col-4">
			<%if(userLoggedIn&&userType!=2){  %>
				<a href="KursHinzufuegen.jsp" class="btn btn-secondary">Einen Kurs hinzufügen</a>
			<%} %>
		</div>
	</div>
</div>	

<!-- Location assumption -->
<!-- Include for FHDW Location not possible due to different title here-->	
<!-- Embbeded with https://www.embedgooglemap.net/ , set widht to 100% for "responsiveness"-->
<div class="container-fluid padding">
	<div class="row text-center padding">
		<div class="col-12">
			<h2>Hier finden aktuell die meisten Kurse statt.</h2>
			<div class="mapouter">
				<div class="gmap_canvas">
					<iframe width="75%" height="300" id="gmap_canvas" src="https://maps.google.com/maps?q=fhdw%20bielefeld&t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0">
					</iframe>
				</div>
			<style>.mapouter{text-align:center;height:300px;width:100%;}.gmap_canvas {overflow:hidden;background:none!important;height:300px;width:100%;}
			</style>
			</div>
		</div>
	</div>
</div>

<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>