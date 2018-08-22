<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%! String nav = "includes/start.jsp"; %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>tutor24</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<!--Social Media Icons -->
	<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script> 
	
	<link href="style.css" rel="stylesheet">
</head>
<body>

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
				<li class="nav-item active">
					<a class="nav-link" href="#">Home</a>
				</li>	
				<li class="nav-item">
					<a class="nav-link" href="#">About</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Services</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Team</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Connect</a>
				</li>
			</ul>
		</div>
	</div>
</nav>

<!--- Image Slider -->

<div id="slides" class="carousel slide" data-ride="carousel">
	<!-- links on the bottom of the slider; can´t be seen without images-->
	<ul class="carousel-indicators">
		<li data-target="#slides" data-slide-to="0" class="active"></li>
		<li data-target="#slides" data-slide-to="1"></li>
		<li data-target="#slides" data-slide-to="2"></li>
	</ul>
	<!-- Images in the slider; needs one active -->
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img src="img/background.png" class="active">
			<!--Content on the slider -->
			<div class="carousel-caption">
				<h1 class="display-2">Tutor24</h1>
				<h3>Dummy Website</h3>
				<button type="button" class="btn-outline-light btn-lg">Demo</button>
				<button type="button" class="btn-primary btn-lg">Demo2</button>
			</div>
		</div>
		<div class="carousel-item">
			<img src="img/background2.png">
		</div>
		<div class="carousel-item">
			<img src="img/background3.png">
		</div>
	</div>
</div>

<!--- Jumbotron -->
<!-- images not centered? -->

<div class="container-fluid">
	<div class=" row jumbotron">
		<div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
			<p class="lead"> Bla bla bla bla </p>
		</div>
		<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-2">
		<a href="#"><button type="button" class="btn btn-outline-secondary btn-lg">Demo3</a>
		</div>
	</div>
</div>

<!--- Welcome Section -->
<div class="container-fluid padding">
	<div class="row welcome text-center">
		<div class="col-12">
			<h1 class="dsplay-4">Schnell bootstrap Lernen mit Tutor24.</h1>
		</div>
		<hr>
			<div class="col-12">
				<p class="lead">Random Text</p>
			</div>
	</div>
</div>


<!--- Three Column Section -->
<!-- care about the used class for the font awesome icons if you swap them -->

<div class="container-fluid padding">
	<div class="row text-center padding">
		<!-- first columns -->
		<div class="col-xs-12 col-sm-6 col-md-4">
			
			<i class="fas fa-code"></i>
			<h3>Study</h3>
			<p>Buuhuu</p>
		</div>
		<!-- second columns -->
		<div class="col-xs-12 col-sm-6 col-md-4">
			<i class="fas fa-bold"></i>
			<h3>Sleep</h3>
			<p>Zzzzzzz</p>
		</div>
		<!-- third columns -->
		<div class="col-sm-12 col-md-4">
			<i class="fab fa-css3"></i>
			<h3>Repeat</h3>
			<p>Circles</p>
		</div>
		
	</div>
	<!-- Distance to the other sections -->
	<hr class="my-4">
</div>

<!--- Two Column Section -->

<div class="container-fluid padding">
	<div class="row padding">
		<!-- first column -->
		<div class="col-lg-6">
			<h2>Just LolZ</h2>
			<p>Paragraph 1</p>
			<p>Paragraph 2</p>
			<br>
			<a href="#" class="btn btn-primary">Testbutton3</a>
		</div>
		<!-- second column -->
		<div class="col-lg-6">
			<img src="img/desk.png" class="img-fluid">
		</div>
	</div>
	<!-- horizontal rule -->
	<hr class="my-4">
</div>	

<!--- Fixed background -->

<figure>
	<div class="fixed-wrap">
		<div id="fixed">
		</div>
	</div>
</figure>

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

<!--- Meet the team -->

<div class="container-fluid padding">
	<div class="row welcome text-center padding">
		<div class="col-12">
			<h1 class="display-4">Meet the Team</h1>
		</div>
	</div>
</div>	

<!--- Cards (for the single teammembers for example) -->

<div class="container-fluid padding">
	<div class="row padding">
		<div class="col-md-3">
			<div class="card">
				<img class="card-img-top" src="img/team1.png">
				<div class="card-body">
					<h4 class="card-title">Thomas</h4>
					<p class="card-text">Product Owner</p>
					<a href="#" class="btn btn-outline-secondary">Check Profile</a>
				</div>
			</div>			
		</div>
		<div class="col-md-3">
			<div class="card">
				<img class="card-img-top" src="img/team2.png">
				<div class="card-body">
					<h4 class="card-title">David</h4>
					<p class="card-text">SCRUM-Master</p>
					<a href="#" class="btn btn-outline-secondary">Check Profile</a>
				</div>
			</div>			
		</div>
		<div class="col-md-3">
			<div class="card">
				<img class="card-img-top" src="img/team3.png">
				<div class="card-body">
					<h4 class="card-title">Marcel</h4>
					<p class="card-text">Developer</p>
					<a href="#" class="btn btn-outline-secondary">Check Profile</a>
				</div>
			</div>			
		</div>
		<div class="col-md-3">
			<div class="card">
				<img class="card-img-top" src="img/team1.png">
				<div class="card-body">
					<h4 class="card-title">Jan</h4>
					<p class="card-text">Developer</p>
					<a href="#" class="btn btn-outline-secondary">Check Profile</a>
				</div>
			</div>			
		</div>
</div>

<!---  Contact Second Two Column Section  -->

<div class="container-fluid padding">
	<div class="row padding">
		<!-- first column -->
		<div class="col-lg-6">
			<h2>Contact us here</h2>
			<p>Paragraph 3, apparently. The image can be the placeholder for a contact formular.</p>
			
		</div>
		<!-- second column -->
		<div class="col-lg-6">
			<img src="img/bootstrap2.png" class="img-fluid">
		</div>
	</div>
	<!-- Horizontal rule again -->
	<hr class="my-4">
</div>	

<!--- Connect -->

<div class="container-fluid padding">
	<div class="row text-center padding">
		<div class="col-12">
			<h2>Connect</h2>
		</div>
		<div class="col-12 social padding">
		<a href="#"><i class="fab fa-facebook"></i></a>
		<a href="#"><i class="fab fa-twitter"></i></a>
		<a href="#"><i class="fab fa-google-plus-g"></i></a>
		<a href="#"><i class="fab fa-instagram"></i></a>
		<a href="#"><i class="fab fa-youtube"></i></a>
	</div>
</div>

<!--- Location -->
<!-- Embbeded with https://www.embedgooglemap.net/ , set widht to 100% for "responsiveness"-->

<div class="container-fluid padding">
	<div class="row text-center padding">
		<div class="col-12">
			<h2>Location</h2>
			<div class="mapouter">
				<div class="gmap_canvas">
					<iframe width="100%" height="300" id="gmap_canvas" src="https://maps.google.com/maps?q=fhdw%20bielefeld&t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0">
					</iframe>
				</div>
			<style>.mapouter{text-align:center;height:300px;width:100%;}.gmap_canvas {overflow:hidden;background:none!important;height:300px;width:100%;}
			</style>
			</div>
		</div>
	</div>
</div>

<!--- Footer -->
<footer>
	<div class="container-fluid padding">
		<div class="row text-center padding">
			<div class="col-md-4">
				<img src="img/w3newbie.png">
				<hr class="light">
				<p>Phone Number</p>
				<p>E-Mail</p>
				<p>Adress</p>
				<p>Zip Code</p>
			</div>
			<div class="col-md-4">
				<hr class="light">
				<h5>Open Hours</h5>
				<hr class="light">
				<p>Open all</p>
				<p>the fucking</p>
				<p>time</p>
				<p>Bitches</p>
			</div>
			<div class="col-md-4">
				<hr class="light">
				<h5>Business</h5>
				<hr class="light">
				<p>Get</p>
				<p>Money</p>
				<p>Fuck</p>
				<p>Bitches</p>
			</div>
			<div class="col-12">
			<hr class="light-100">
			<h5>&copy; No rights reserved.</h5>
		</div>
	</div>
</footer>

</body>
</html>