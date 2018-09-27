<!-- Navigation -->
<!-- md is breakpiont for change from mobile, light means the color theme -->
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
	<!--bootstrap container 100% of the screen-->
	<div class="container-fluid">
	
		<!--Logo at the top -->
		<a class="navbar-brand" href="home.jsp"><img src="img/logo.png"></a>
		
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
					<a class="nav-link" href="home.jsp">Zurück zur Hauptseite</a>
				</li>	
				<li class="nav-item">
					<a class="nav-link" href="admin.jsp">Admin Startseite</a>
				</li>	
				<li class="nav-item">
					<!-- Form for call the GetProducts Servlet -->
					<!-- the action "GetProducts" call the servlet, to call the servlet it has to-->
					<!-- be mapped in the web.xml-->
					<form  action="GetCourses" method="get">
						<input type="submit" class="nav-link nav-link-input" id = "getCourses" value="Kurs Übersicht">
						<input type="hidden" name="targetSite" value="/adminKursuebersicht.jsp">
					</form>
				</li>
<%--			<li class="nav-item">
					<form  action="GetUser" method="get">
						<input type="submit" class="nav-link" id = "getUser" value="Accounts Übersicht">
					</form>
--%>					
				</li>
				<li class="nav-item">
					<li class="nav-item">
					<a class="nav-link" href="adminStatistiken.jsp">Statistiken</a>
				</li>
				</li>
			</ul>
		</div>
	</div>
</nav>
