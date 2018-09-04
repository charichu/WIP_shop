<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Kurs hinzufügen</title>
	<!-- Imports -->
	<div><jsp:include page="includes/imports.jsp"/></div>
</head>
<body>

<%! Boolean userLoggedIn=false;
	Integer userType;%>
<%	if( session.getAttribute("userLoggedIn") != null)userLoggedIn=(Boolean) session.getAttribute("userLoggedIn");
	if( session.getAttribute("userType")     != null)userType=(Integer) session.getAttribute("userType"); %>
<!-- Navigation and Login -->

<%	if( userLoggedIn==true && userType != 2){ %> 

<%  if(userType==0){ %>
<div><jsp:include page="includes/adminNavigation.jsp"/></div>
<%  }
	else{%>
<div><jsp:include page="includes/navigation.jsp"/></div>
<%  }%>
<div class="container-fluid padding">
	<form action="CreateCourse" class="row" method="get">
		<div class="col-8">
			<table>
			<% if(userType==0){ %>
				<tr>
					<td>Lehrer ID<br>Für welchen Lehrer wollen Sie den Kurs anlegen?</td>
					<td><input type="text" name="txtUserId" placeholder="LehrerID" required="required"></td>
				</tr>
			<% } %>
				<tr>
					<td>Fach:*</td>
					<td><input type="text" name="txtSubject" placeholder="Fach" required="required"></td>
				</tr>
				<tr>
					<td>Thema:*</td>
					<td><input type="text" name="txtTopic" placeholder="Thema" required="required"></td>
				</tr>
				<tr>
					<td>Jahrgangsstufe:*</td>
					<td><input type="number" name="txtGrade" placeholder="Jahrgang" required="required" pattern="[0-9]{1-2}"></td>
				</tr>
				<tr>
					<td>Beschreibung:</td>
					<td><input type="text" name="txtDescription" placeholder="Beschreibung" ></td>
				</tr>
				<tr>
					<td>Für welche Gruppe: <br> Schüler o. Studenten</td>
					<td><input type="text" name="txtStudentType" placeholder="Schüler/ Studenten"></td>
				</tr>
				<tr>
					<td>Preis pro Stunde Nachhilfe:*</td>
					<td><input type="text" name="txtPricePerHour" placeholder="Preis" required="required" pattern="[0-9]{1,}" title="Bitte einen richtigen Preis angeben"></td>
				</tr>
				<tr>
					<td>Kapazität eines Kurses:</td>
					<td><input type="text" name="txtCapacity" placeholder="Kapazität" required="required"></td>
				</tr>
				<tr>
					<td>Frequenz:</td>
					<td><input type="text" name="txtFrequency" placeholder="Frequenz"></td>
				</tr>
				<tr>
					<td>Dauer eine Nachhilfe(in Stunden):</td>
					<td><input type="text" name="txtDurationPerMeeting" placeholder="Dauer" pattern="[0-9]"></td>
				</tr>
				<tr>
					<td>Adresse:*</td>
					<td>
						<input type="text" name="txtStreetHouseNumber" placeholder="Straße Nr." required="required" pattern="[a-zA-Z0-9]+[ ]{1}+[0-9]"><br>
						<input type="text" name="txtPLZ" placeholder="PLZ" required="required" pattern="[0-9]{1-5}"><br>
						<input type="text" name="txtCity" placeholder="Ort" required="required" pattern="[a-zA-Z]{1,}"><br>
					</td>
				</tr>
				<tr>
					<td>Mit * markierte Felder sind Pflichtfelder.</td>
				</tr>
			</table>
		</div>
		<div class="col-4">
			<input type="submit" id="subCreateCourse" value="Kurs hinzufügen">
		</div>
	</form>
</div>
<%	}
	else{%>
<div class="container-fluid padding">
	<div class="row">
		<div class="col-12">
			Da sind kein Lehrer, können diese Funktion nicht benutzen.
				<a class="col-2 nav-link" href="home.jsp">Zurück zur Startseite</a>
		</div>
	</div>
</div>	
<%} %>
<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>
</html>