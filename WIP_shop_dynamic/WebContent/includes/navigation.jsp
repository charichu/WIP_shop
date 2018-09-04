<!-- Navigation -->
<!-- md is breakpiont for change from mobile, light means the color theme -->
<%@page import="javax.websocket.Session"%>
<%@page pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
<%-- variable declaration and initialization --%>
<%!		Boolean userLoggedIn;
		Integer     userType;%>
	<% 	
		if(session.getAttribute("userLoggedIn") == null){
			userLoggedIn = false;
		}
		else{
			userLoggedIn = (Boolean) session.getAttribute("userLoggedIn");
		}
		if(session.getAttribute("userType") != null){
			userType = (Integer) session.getAttribute("userType");
		}
		%>
		
	<!--bootstrap container 100% of the screen-->
	<div class="container-fluid">
	
		<!--Logo at the top -->
		<a class="navbar-brand" href="index.html"><img src="img/logo.png"></a>
		<%
			if(session.getAttribute("userName") != null){
				out.println("Willkommen "+session.getAttribute("userName"));
			}
			%>
		<!-- navigation toggle button -->
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<!-- id and class for the navbar -->
		<div class="collapse navbar-collapse" id="navbarResponsive">
			
			<!-- ml pushes the navigation to the right side when it is in full width -->
			<ul class="navbar-nav ml-auto">
			
				<!-- Pages in the navigation -->
				<li class="nav-item">
					<a class="nav-link" href="home.jsp">Home</a>
				</li>	
				<li class="nav-item">
					<form  action="GetCourses" method="get">
						<input type="submit" class="nav-link" id = "getCourses" value="Kurs Übersicht">
						<input type="hidden" name="targetSite" value="/Kursangebote.jsp">
					</form>
				</li>
				
				<%-- show this fields if the user is logged in and the user is not an admin --%>
				<% if(userLoggedIn && userType != 0){ %>
				<li class="nav-item">
					<a class="nav-link" href="Kalender.jsp">Kalender</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="MeineKurse.jsp">Meine Kurse</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="Profil.jsp">Profil</a>
				</li>
				<%} %>
				<li class="nav-item">
					<a class="nav-link" href="Warenkorb.jsp">Warenkorb</a>
				</li>
				
				<%-- if the user is logged in it show the logout button --%>
				<% 	if(!userLoggedIn){ %>
				<li class="nav-item"> <!-- Login link differs because it opens a modul -->
					<a class="nav-link" href="#" data-toggle="modal" data-target="#login-modal">Login</a>
				</li>
				<% 	}
					else{%>
				<li class="nav-item">
					<form action="Logout" method="post">
						<input type="submit" class="nav-link" id="subLogout" value="Abmelden">
					</form>
				</li>
				<%	}%>
				
				<%-- show the link to the admin page if the user is logged in and the user is an admin--%>
				<% 	if(userLoggedIn && userType == 0){%>
					<li class="nav-item">
						<a class="nav-link" href="admin.jsp">Administrator Seite</a>
					</li>
				<% 	} %>
			</ul>
		</div>
	</div>
</nav>

<!-- Login -->

<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
		<div class="loginmodal-container modal-content">
			<h1>Login to Your Account</h1><br>
			<form action="Login" method="post">
				<input type="text" name="user" placeholder="E-Mail" pattern="">
				<input type="password" name="pass" placeholder="Password">
				<input type="submit" name="login" class="login loginmodal-submit" value="Login">
			</form>
					
				 <div class="login-help">
				 <!--Links to register and Password reset -->
					<a href="#">Register</a> - <a href="#">Forgot Password</a>
				 </div>
			<% 	if(request.getAttribute("loginResultMessage") != null){
					out.println(request.getAttribute("loginResultMessage"));
				} %>	 
		</div>
	</div>