<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Home</title>
	<!-- Imports -->
	<div><jsp:include page="includes/imports.jsp"/></div>
</head>
<body>

<!-- Navigation and Login -->
<div><jsp:include page="includes/navigation.jsp"/></div>
<div><jsp:include page="includes/scripts.jsp"/></div>

<!--- Image Slider -->
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
			
			<i class="fas fa-graduation-cap"></i>
			<h3>Study</h3>
			<p>Buuhuu</p>
		</div>
		<!-- second columns -->
		<div class="col-xs-12 col-sm-6 col-md-4">
			<i class="fab fa-empire"></i>
			<h3>Sleep</h3>
			<p>Zzzzzzz</p>
		</div>
		<!-- third columns -->
		<div class="col-sm-12 col-md-4">
			<i class="fas fa-chart-line"></i>
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

<!--- Connect-->
<div><jsp:include page="includes/connect.jsp"/></div>

<!--- Location -->
<div><jsp:include page="includes/location.jsp"/></div>	

<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>