<%@page import="functions.Functions_Std"%>
<%@page import="sun.reflect.ReflectionFactory.GetReflectionFactoryAction"%>
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
		<form action="RecoveryServlet" method="post">
		<% if(!Functions_Std.isStringNullOrEmpty(request.getQueryString()) && request.getQueryString().indexOf("id=") >= 0 && request.getQueryString().indexOf("&code=") > 0){%>
			<p2 class="help-block">Geben Sie Ihr neues Passwort ein.</p2>
			<input type="text" name="txtNewPassword" placeholder="Neues Password">
			<input type="submit" name="btnNewPassword" class="login registermodal-submit" value="Passwort ändern">
			<input type="hidden" name="recoveryTarget" value="/recovery.jsp?<%=request.getQueryString()%>">
		<%}else{%>
			<p2 class="help-block">Sie werden in kurzer Zeit eine Mail mit einem Link zur Passwortwiederherstellung erhalten. </p2>
			<p></p>
			<input type="text" name="txtEmail" placeholder="E-Mailadresse">
			<input type="submit" name="btnRecovery" class="login registermodal-submit" value="Wiederherstellen">
			<input type="hidden" name="recoverySite" value="/recovery.jsp">
		<%} %>
		</form>
</div>
<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>