<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<form action="GetCourses" method="post">			
				<table class="table">
					<tr>
						<td colspan="6">
							Filteroptionen
						</td>
					</tr>
					<tr>
						<td>
							<select name="ddlSubject">
								<option></option>
								<option value="englisch"		>Englisch</option>
								<option value="deutsch"			>Deutsch</option>
								<option value="mathe"			>Mathematik</option>
								<option value="französisch"		>Französisch</option>
								<option value="physik"			>Physik</option>
								<option value="chemie"			>Chemie</option>
								<option value="biologie"		>Biologie</option>
							</select>
						</td>
						<td>
							<input type="number" name="txtPrice" placeholder="Preis:">
						</td>
						<td>
							<input type="number" name="txtCapacity" placeholder="Kursgröße:">
						</td>
						<td>
							<select name="ddlFrequency">
								<option></option>
							<option value="wöchentlich"			>wöchentlich</option>
							<option value="monatlich"			>monatlich</option>
							</select>
						</td>
						
						<td>
							<input type="number" name="txtDuration" placeholder="Dauer:">
						</td>
						<td>
							<input type="submit" name="btnFilter" placeholder="Anwenden">
							<input type="hidden" name="filteredSite" value="Kursangebote.jsp">
						</td>
					</tr>
					<tr>
						<td colspan="6">
							<input type8="search" name="srhCourses" placeholder="Suchen">
						</td>
					</tr>
				</table>
			</form>
			
		<div class="container">
			<div class="well well-sm">
				<strong>Gefundene Kurse</strong>				
			</div>
			<!-- Container where all the products end up -->
			<div  id="divProducts" class="row grid-group">
			<%
			ArrayList<Course> list = (ArrayList<Course>) request.getAttribute("courses");
			if(list != null){
			%>
			<%-- display the products in the table --%>
				<% 		list.remove(0);
						for(Course course:list){%>
								
				<div class="item col-xs-6 col-lg-6 col-xl-4">
				<!-- Product picture -->
					<div class="thumbnail">
						<img class="group grid-group-image" src="img/thumbnail.png" alt="" />
						<div class="caption">
							<!-- Product title -->
							<h4 class="group inner grid-group-item-heading">
								<%out.println(course.getTopic()); %>
							</h4>
								<!-- Product Tooltip -->
								<p class="group-inner grid-group-item-text">
									<%out.println(course.getDescription().substring(0, course.getDescription().length()<50?course.getDescription().length():50) + "..."); %>
								</p>
							<div class="row">
								<div class="col-xs-12 col-md-6">
								<!-- Product Price -->
								<p class="lead">
									<%out.println(course.getPricePerHour() + ",00 €"); %>
								</p>
							</div>
						<!-- Jump to Detailed View -->
						<div class="col-xs-12 col-md-6">
							<a class="btn btn-success" href="DisplayDetails?courseID=<%=course.getCourseNumber()%>">Details</a>	
						</div>
					</div>
				</div>
			</div>
		</div>
		<%  	}
			}%>
	</div>
</div>
</div>

<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>