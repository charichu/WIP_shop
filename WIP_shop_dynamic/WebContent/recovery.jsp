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

<!-- Register Form -->

<div class="registermodal-container modal-content">
	<h1>Passwortwiederherstellung</h1><br>
		<form>
			<p2 class="help-block">Sie werden in kurzer Zeit eine Mail mit einem Link zur Passwortwiederherstellung erhalten. </p2>
			<p></p>
			<input type="text" name="email" placeholder="E-Mailadresse">
			<input type="submit" name="recovery" class="login registermodal-submit" value="Wiederherstellen">
		</form>
</div>
<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>