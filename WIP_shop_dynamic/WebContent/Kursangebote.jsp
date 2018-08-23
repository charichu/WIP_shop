<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Kursangebote</title>
	<!-- Imports -->
	<div><jsp:include page="includes/imports.jsp"/></div>
</head>
<body>

<!-- Navigation and Login -->
<div><jsp:include page="includes/navigation.jsp"/></div>

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

<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>