<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%! String nav = "includes/start.jsp"; %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<link href = "style.css" rel = "stylesheet">
</head>

<body>
	<div id = "wrapper">
		<jsp:include page="includes/header.jsp"/>
		<div id= "websiteContent">
			<form action="./WebContent/WEB-INF/lib/RegistrationServlet" method="post">
				<table>
					<tr>
						<td>
							Email
						</td>
						<td>
							<input id="txtEmail" type="text">
						</td>
					</tr>
					<tr>
						<td>
							Username
						</td>
						<td>
							<input id="txtUsername" type="text">
						</td>
					</tr>
					
					<tr>
						<td>
							Password
						</td>
						<td>
							<input id="txtPassword" type="password">
						</td>
					</tr>
					
					<tr>
						<td>
							Lehrer
						</td>
						<td>
							<input id="chkTeacher" type="checkbox">
						</td>
					</tr>
					
					<tr>
						<td>
							Name
						</td>
						<td>
							<input id="txtFirstName" type="text">
						</td>
					</tr>
					
					<tr>
						<td>
							Nachname
						</td>
						<td>
							<input id="txtLastName" type="text">
						</td>
					</tr>
					<tr>
						<td>
							Geburtsdatum
						</td>
						<td>
							<input id="txtBirthday" type="text">
						</td>
					</tr>
					<tr>
						<td>
							Klasse
						</td>
						<td>
							<input id="txtClass" type="text">
						</td>
					</tr>
					<tr>
						<td>
							Schüler
						</td>
						<td>
							<input id="chkStudent" type="checkbox">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input id="btnSubmit" type="submit">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<jsp:include page="includes/footer.jsp"/>
	</div>
</body>
</html>