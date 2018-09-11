<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="functions.User" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Profil</title>
	<!-- Imports -->
	<div><jsp:include page="includes/imports.jsp"/></div>

</head>
<body>

<!-- Navigation and Login -->
<div><jsp:include page="includes/navigation.jsp"/></div>
<div><jsp:include page="includes/scripts.jsp"/></div>
<script type="text/javascript">
$(document).ready(function () {
	$('#edit').click(function() {
		$("#submit").prop("hidden", false);
		$("#edit").prop("hidden", true);
		
		$("#txtEmail").prop("disabled", false);
		$("#txtLastName").prop("disabled", false);
		$("#qualificationProfile").prop("disabled", false);
		$("#txtStreetHousenumber").prop("disabled", false);
		$("#txtPlz").prop("disabled", false);
		$("#txtCity").prop("disabled", false);
		$("#txtGrade").prop("disabled", false);
	});
});
</script>
<!--- Two Column Section -->
<div class="container-fluid padding">
	<div class="row padding">
		<!-- first column -->
		<div class="col-lg-6">
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
					<h1>Profil</h1><input type="submit" id="edit" value="bearbeiten">
					<form id="target" action="UpdateProfile" method="get">
						<input type="submit" id="submit" value="bestätigen" hidden="hidden">
					
			<% User currentUser = (request.getAttribute("currentUser")!=null)?(User)request.getAttribute("currentUser"):null;
			   if(currentUser!=null){%>
				<table id="profileTable">
					<tr>
						<td>Username: </td><td><input name="txtUsername" type="text" disabled="disabled" value="<%=currentUser.getUsername()%>" ></td>
					</tr>
					<tr>
						<td>Passwort zurücksetzen: </td><td><a href="">Passwort zurücksetzen</a></td>
					</tr>
					<tr>	
						<td>E-Mail:</td><td><input id="txtEmail" name="txtEmail" type="email" disabled="disabled" value="<%=currentUser.getEmail()%>"></td>
					</tr>
					<tr>	
						<td>Vor-/ Nachname: </td><td><input name="txtFirstName" type="text" disabled="disabled" value="<%=currentUser.getFirstName()%>">
													 <input id="txtLastName" name="txtLastName" type="text" disabled="disabled" value="<%=currentUser.getLastName()%>"></td>
					</tr>
					<tr>	
						<td>Geburtstag:</td><td><input name="dateOfBith" type="text" disabled="disabled" value="<%=currentUser.getDateOfBirth()!=null?currentUser.getDateOfBirth():""%>" pattern="[0-9]{1-2}.[0-9]{1-2}.[0-9]{4}"></td>
					</tr>
					<tr>	
						<%if((Integer)session.getAttribute("userType")==1){ 
							HashMap<String,String> address = currentUser.getAddress(); %>
							<td>Qualifikations Profil</td><td><textarea rows="5" cols="40" id="qualificationProfile" name="qualificationProfile" form="" disabled="disabled"><%=currentUser.getQualificationProfile()!=null?currentUser.getQualificationProfile():""%></textarea></td>
							</tr>
							<tr>
							<td>Straße/ Nr:</td><td><input id="txtStreetHousenumber" name="txtStreetHousenumber" type="text" value="<%=address.get("street")+" "+address.get("houseNumber")%>" disabled="disabled"></td>
							</tr>
							<tr>
							<td>PLZ:</td><td><input id="txtPlz" name="txtPlz" type="number" value="<%=address.get("plz")%>" disabled="disabled"></td>
							</tr>
							<tr>
							<td>Stadt:</td><td><input id="txtCity" name="txtCity" type="text" value="<%=address.get("city")%>" disabled="disabled"></td>
						<%} %>
						<%if((Integer)session.getAttribute("userType")==2){ %>
							<td>Jahrgangsstufe</td><td><input id="txtGrade" name="txtGrade" type="number" disabled="disabled" value="<%=currentUser.getGrade().intValue()%>"></td>
						<%} %>
						
					</tr>
				</table>
				
			<% } %>
			</form>
		</div>
		<!-- second column -->
		<div class="col-lg-6">
			<img src="img/desk.png" class="img-fluid">
		</div>
	</div>
	<!-- horizontal rule -->
	<hr class="my-4">
</div>	

<!--- Hidden (Gif) Section -->

<button class="hiddensection" data-toggle="collapse" data-target="#secrets">Don´t Dead open inside</button>

<div id="secrets" class="collapse">
	<div class="container-fluid padding">
		<div class="row text-center">
			<!-- four columns to a single column -->
			<div class="col-sm-6 col-md-3">
				<img class="gif" src="img/gif/panda.gif">
			</div>
			<div class="col-sm-6 col-md-3">
				<img class="gif" src="img/gif/poo.gif">
			</div>
			<div class="col-sm-6 col-md-3">
				<img class="gif" src="img/gif/unicorn.gif">
			</div>
			<div class="col-sm-6 col-md-3">
				<img class="gif" src="img/gif/chicken.gif">
			</div>
		</div>
	</div>		
</div>

<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>