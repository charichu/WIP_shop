<%@page import="functions.Address" %>
<%@page import="courseFunctions.Course"%>
<%@page import="java.util.Hashtable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Kurs Details</title>
	<!-- Imports -->
	<div><jsp:include page="includes/imports.jsp"/></div>
	<div><jsp:include page="includes/scripts.jsp"/></div>
</head>
<body>

<div><jsp:include page="includes/adminNavigation.jsp"/></div>

<%-- Get variable from Servlet; with controll if null --%>
<%		Course course = request.getAttribute("course")!=null?(Course)request.getAttribute("course"):new Course();
		Address address = request.getAttribute("address")!=null?(Address)request.getAttribute("address"):new Address();
 %>
<!-- Course Details -->
<div class="container-fluid padding">
	<div class="row">
		<div class="col-lg-8 col-md-8 col-s-8">
			<% if(request.getAttribute("errorMessage")!=null){%>
				<div id="alert_message" class="alert alert-danger" role="alert">
				  <% out.println(request.getAttribute("errorMessage")); %>
				</div>
			<%	}%>
			<%if(!course.isEmpty()){ %>
					
					<form id="EditCourse" action="EditCourseAdmin" method="post">
						<input type="hidden" name="courseID" value="<%=course.getCourseNumber()%>">
						<input type="hidden" name="addressID" value="<%=course.getAddressID()%>">
						<table>
							<tr><td><a class="nav-link" href="DeleteCourse?courseID=<%=course.getCourseNumber()%>">Löschen</a></td><td><input type="submit" value="bestätigen"></td></tr>
							<tr><td><h2>Kurs:</h2></td></tr>
							<tr><td>Kurs Nummer:</td><td><label><%=course.getCourseNumber()%></label></td></tr>
							<tr><td>Fach:</td><td><label><input type="text" name="txtSubject" required="required" value="<%=course.getSubject()%>"></label></td></tr>
							<tr><td>Beschreibung:</td><td><textarea name="txtDescription"><%=course.getDescription()%></textarea></td></tr>
							<tr><td>Für Schüler/ Studenten:</td><td><input type="text" name="txtStudentType"  value="<%=course.getStudentType()%>"></td></tr>
							<tr><td>Preis in €(pro Stunde):</td><td><input type="text" name="txtPricePerHour" required="required"  value="<%=course.getPricePerHour()%>"></td></tr>
							<tr><td>Kapazität:</td><td><input type="text" name="txtCapacity" required="required" value="<%=course.getCapacity()%>"></td></tr>
							<tr><td>Frequenz(z.B. wöchentlich, monatlich):</td.><td><input type="text" name="txtFrequency"  value="<%=course.getFrequency()%>"></td></tr>
							<tr><td>Dauer pro Nachhilfetermin(in min):</td><td><input type="text" name="txtDurationPerMeeting" required="required" value="<%=course.getDurationPerMeeting()%>"></td></tr>
							<tr><td>Für welche Jahrgangsstufe:</td><td><input type="number" name="txtGrade" required="required" value="<%=course.getGrade()%>"></td></tr>
							<%if(!address.isEmpty()){ %>
								<tr><td><h2>Adresse:</h2></td></tr>
								<tr>
									<td>Postleitzahl Ort:</td>
									<td>
										<input type="number" name="txtPLZ" required="required" value="<%=address.getPlz()%>">
										<input type="text" name="txtCity" required="required" value="<%=address.getCity()%>">
									</td>
								</tr>
								<tr>
									<td>Straße Nr.:</td>
									<td>
										<input type="text" name="txtStreet" required="required" value="<%=address.getStreet()%>">
										<input type="number" name="txtHouseNumber" required="required" value="<%=address.getHouseNumber()%>">
									</td>
								</tr>
							<%}%>
						</table>
					</form>
			<%}
			  else{%>
			  Zu diesem Kurs sind leider keine Informationen verfügbar.
			<%} %>
		</div>
		<div class="col-lg-4 col-md-4 col-s-4">
			<img class="img-fluid" alt="vorschauBild" src="img/nachhilfesv.jpg">
		</div>
	</div>
</div>
<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>
</html>