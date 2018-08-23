<!-- Navigation -->
<!-- md is breakpiont for change from mobile, light means the color theme -->
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
	<!--bootstrap container 100% of the screen-->
	<div class="container-fluid">
	
		<!--Logo at the top -->
		<a class="navbar-brand" href="index.html"><img src="img/logo.png"></a>
		
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
					<a class="nav-link" href="Kursangebote.jsp">Kursangebote</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="Kalender.jsp">Kalender</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="MeineKurse.jsp">Kurse</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="Profil.jsp">Profil</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="Statistiken.jsp">Statistiken</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="Nutzeruebersicht.jsp">Nutzeruebersicht</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="Warenkorb.jsp">Warenkorb</a>
				</li>
				<li class="nav-item"> <!-- Login link differs because it opens a modul -->
					<a class="nav-link" href="#" data-toggle="modal" data-target="#login-modal">Login</a>
				</li>
			</ul>
		</div>
	</div>
</nav>

<!-- Login -->

<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
		<div class="loginmodal-container modal-content">
			<h1>Login to Your Account</h1><br>
			<form>
				<input type="text" name="user" placeholder="Username">
				<input type="password" name="pass" placeholder="Password">
				<input type="submit" name="login" class="login loginmodal-submit" value="Login">
			</form>
					
				 <div class="login-help">
				 <!--Links to register and Password reset -->
					<a href="#">Register</a> - <a href="#">Forgot Password</a>
				 </div>
		</div>
	</div>
</div>