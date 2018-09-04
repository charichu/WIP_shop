<%@page import="java.util.Hashtable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Kurs Details</title>
	<!-- Imports -->
	<div><jsp:include page="includes/imports.jsp"/></div>
</head>
<body>
<!-- Navigation and Login -->
<div><jsp:include page="includes/navigation.jsp"/></div>
<%-- Get variable from Servlet; with controll if null --%>
<%		@SuppressWarnings("unchecked")
		Hashtable<String, String> courseDetails=(request.getAttribute("courseDetails") != null)?
												(Hashtable<String, String>)request.getAttribute("courseDetails")
												:null;	
 %>
<!-- Course Details -->
<div class="container-fluid padding">
	<div class="row">
		<div class="col-lg-8 col-md-8 col-s-8">
			<%if(courseDetails!=null){ %>
				
					<table>
						<tr><td><h2>Kurs:</h2></td></tr>
						<tr><td>Kurs Nummer:</td><td><label><%out.println(courseDetails.get("courseID")); %></label></td></tr>
						<tr><td>Fach:</td><td><label><%out.println(courseDetails.get("subject")); %></label></td></tr>
						<tr><td>Thema:</td><td><label><%out.println(courseDetails.get("topic")); %></label></td></tr>
						<tr><td>Beschreibung:</td><td><label><%out.println(courseDetails.get("description"));%></label></td></tr>
						<tr><td>Für Schüler/ Studenten:</td><td><label><%out.println(courseDetails.get("studentType"));%></label></td></tr>
						<tr><td>Preis:</td><td><label><%out.println(courseDetails.get("pricePerHour")+" €");%></label></td></tr>
						<tr><td>Kapazität:</td><td><label><%out.println(courseDetails.get("capacity"));%></label></td></tr>
						<tr><td>Frequenz:</td><td><label><%out.println(courseDetails.get("frequency"));%></label></td></tr>
						<tr><td>Dauer pro Nachhilfetermin:</td><td><label><%out.println(courseDetails.get("durationPerMeeting")+" min");%></label></td></tr>
						<tr><td>Für welche Jahrgangsstufe:</td><td><label><%out.println(courseDetails.get("grade"));%></label></td></tr>
						<tr><td><h2>Lehrer:</h2></td></tr>
						<tr><td>Name:</td><td><label><%out.println(courseDetails.get("firstName")+" "+courseDetails.get("lastName"));%></label></td></tr>
						<tr><td>Qualifikation:</td><td><label><%out.println(courseDetails.get("qualificationProfile"));%></label></td></tr>
						<tr><td><h2>Adresse:</h2></td></tr>
						<tr><td>Postleitzahl Ort:</td><td><label><%out.println(courseDetails.get("plz")+" "+courseDetails.get("city"));%></label></td></tr>
						<tr><td>Straße Nr.:</td><td><label><%out.println(courseDetails.get("street")+" "+courseDetails.get("houseNumber"));%></label></td></tr>
					</table>
			<%}
			  else{%>
			  Zu diesem Kurs sind leider keine Informationen verfügbar.
			<%} %>
		</div>
		<div class="col-lg-4 col-md-4 col-s-4">
			<%if(courseDetails!=null){ %>
				<form action="">
					<input type="submit" id="subBuyCourse" value="Kurs buchen">
				</form>
				<img class="img-fluid" alt="vorschauBild" src="img/nachhilfesv.jpg">
			<%} %>
		</div>
	</div>
</div>
<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>
</html>