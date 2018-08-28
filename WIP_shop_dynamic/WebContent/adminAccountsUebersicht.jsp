<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Accounts Übersicht</title>
	<!-- Imports -->
	<div><jsp:include page="includes/imports.jsp"/></div>
</head>
<body>

<!-- Admin-Navigation with servlet call-->
<div><jsp:include page="includes/adminNavigation.jsp"/></div>

<!-- Admin-home content Unfinished with content -->	
	<div id = "wrapper" class="row">
		<div id = "adminContent" class="col-8">
		</div>
		<div id="adminFunctions" class="col-4">
			<table>
				<tr>
					<td>
						<form  action="" method="get">
							<input type="submit" class="nav-link" id = "changeCourse" value="Ändern">
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<form  action="" method="get">
							<input type="submit" class="nav-link" id = "showCourse" value="Anzeigen">
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<form  action="" method="get">
							<input type="submit" class="nav-link" id = "deleteCourse" value="Löschen">
						</form>
					</td>
					
				</tr>
			</table>
		</div>
	</div>
<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

	
</body>


</html>

