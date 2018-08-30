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
			<form action="registration" method="post">
				<table>
					<tr>
						<td>
							Email
						</td>
						<td>
							<input name="txtEmail" type="text">
						</td>
					</tr>
					<tr>
						<td>
							Username
						</td>
						<td>
							<input name="txtUsername" type="text">
						</td>
					</tr>
					
					<tr>
						<td>
							Password
						</td>
						<td>
							<input name="txtPassword" type="password">
						</td>
					</tr>
					
					<tr>
						<td>
							Lehrer
						</td>
						<td>
							<input name="chkTeacher" type="checkbox">
						</td>
					</tr>
					
					<tr>
						<td>
							Name
						</td>
						<td>
							<input name="txtFirstName" type="text">
						</td>
					</tr>
					
					<tr>
						<td>
							Nachname
						</td>
						<td>
							<input name="txtLastName" type="text">
						</td>
					</tr>
					<tr>
						<td>
							Geburtsdatum
						</td>
						<td>
							<input name="txtBirthday" type="text">
						</td>
					</tr>
					<tr>
						<td>
							Klasse
						</td>
						<td>
							<input name="txtClass" type="text">
						</td>
					</tr>
					<tr>
						<td>
							Schüler
						</td>
						<td>
							<input name="chkStudent" type="checkbox">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input name="btnSubmit" type="submit">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<jsp:include page="includes/footer.jsp"/>
	</div>
</body>
</html>