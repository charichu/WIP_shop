<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Registrierung</title>
	<!-- Imports -->
	<div><jsp:include page="includes/imports.jsp"/></div>
</head>
<body>

<!-- Navigation and Login -->
<div><jsp:include page="includes/navigation.jsp"/></div>

<!-- Register Form  -->

<div class="registermodal-container modal-content">
	<h1>Registrierung</h1><br>
		<form action="registration" method="post">
			<!-- Future Login Data -->
			<p2 class="help-block">Login-Daten: </p2>
				<input type="text" name="txtUsername" placeholder="Username">
				<input type="password" name="txtPassword" placeholder="Password, keine &bdquo;&ldquo; oder ;">
				<!-- checked out due to placeholder text <p class="help-block">Alle Zeichen außer " und ;.</p> -->
			<!-- User Info -->
			<p2 class="help-block">User-Daten: </p2>
				<input type="text" name="txtEmail" placeholder="E-Mailadresse">
				<input type="text" name="txtLastName" placeholder="Nachname">
				<input type="text" name="txtFirstName" placeholder="Vorname">
				<input type="text" name="chkStudentType" placeholder="Schüler oder Student">
				<input type="text" name="txtClass" placeholder="Schulklasse,bitte leer lassen wenn Student">
				<!-- Type Date does not allow placeholder text -->
				<input type="text" name="numDateOfBirth" placeholder="Geburtstag, Format tt.mm.jjjj">
					<!-- checked out due to the type number work around <p class="help-block">Geben Sie hier ihr Geburtsdatum ein.</p>  -->
			<!-- Address Block -->
			<p2 class="help-block">Adresse: </p2>
				<input type="number" name="txtPlz" placeholder="Postleitzahl">
				<input type="text" name="txtCity" placeholder="Stadt">
				<input type="text" name="txtStreet" placeholder="Straße">
				<input type="number" name="txtHousenumber" placeholder="Hausnummer">			
			<!-- UserType selection -->
			<br>	
			<input type="checkbox" id="chkUserTypeTeacher" name="userType" value="teacher">
			<label for="userTypeTeacher">Bitte ankreuzen, wenn Sie sich als Lehrer anmelden wollen.</label>
			<!-- Register button -->
				<input type="submit" name="register" class="login registermodal-submit" value="Registrieren">
		</form>
</div>
<!--- Jumbotron -->
<!-- images not centered? -->

<div class="container-fluid">
	<div class=" row jumbotron">
		<div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
			<p class="lead"> Bla bla bla bla </p>
		</div>
		<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-2">
		<a href="#"><button type="button" class="btn btn-outline-secondary btn-lg">Demo3</a>
		</div>
	</div>
</div>
<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>