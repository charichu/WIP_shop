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
				<input type="text" name="txtUsername" placeholder="Username" required="required">
				<input type="password" name="txtPassword" placeholder="Password, keine &bdquo;&ldquo; oder ;" required="required">
				<!-- checked out due to placeholder text <p class="help-block">Alle Zeichen außer " und ;.</p> -->
			<!-- User Info -->
			<p2 class="help-block">User-Daten: </p2>
				<input type="text" name="txtEmail" placeholder="E-Mailadresse" required="required">
				<input type="text" name="txtLastName" placeholder="Nachname" required="required">
				<input type="text" name="txtFirstName" placeholder="Vorname" required="required">
				<input type="text" name="chkStudentType" placeholder="Schüler oder Student" required="required">
				<input type="text" name="txtClass" placeholder="Schulklasse,bitte leer lassen wenn Student">
				<!-- Type Date does not allow placeholder text -->
				<input type="text" name="numDateOfBirth" pattern="[0-9]{1-2}.[0-9]{1-2}.[0-9]{4}" placeholder="Geburtstag, Format tt.mm.jjjj" required="required">
					<!-- checked out due to the type number work around <p class="help-block">Geben Sie hier ihr Geburtsdatum ein.</p>  -->
			<!-- Address Block -->
			<p2 class="help-block">Adresse: </p2>
				<input type="number" name="txtPlz" placeholder="Postleitzahl" required="required">
				<input type="text" name="txtCity" placeholder="Stadt" required="required">
				<input type="text" name="txtStreet" placeholder="Straße" required="required">
				<input type="number" name="txtHousenumber" placeholder="Hausnummer" required="required">			
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
			<p class="lead">Mit ihrerer Registierung werden Sie eine Mail erhalten und dort einen Link zur Aktivierung erhalten.</p>
		</div>
	</div>
</div>
<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>