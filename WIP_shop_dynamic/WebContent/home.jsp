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
				<h3>Hier werden Sie schlauer!</h3>
				<a class="btn btn-primary"role="button" href="GetCourses?targetSite=%2FKursangebote.jsp">Hier zu den Kursangebote</a>
			</div>
		</div>
		<div class="carousel-item">
			<img src="img/background2.png">
			<!--Content on the slider -->
			<div class="carousel-caption">
				<h3>Lege direkt los und logge dich ein!</h3>
				<a data-toggle="modal" class="btn btn-primary" href="#" data-target="#login-modal">Login</a>
			</div>
		</div>
		<div class="carousel-item">
			<img src="img/background3.png">
		</div>
	</div>
</div>

<!--- Welcome Section -->
<div class="container-fluid padding">
	<div class="row welcome text-center">
		<div class="col-12">
			<h1 class="dsplay-4">Beste Nachhilfe für jedes Budget.</h1>
		</div>
		<hr>
			<div class="col-12">
				<p class="lead">Wir verhelfen Ihnen zu einer guten Work-Life Balance bei optimalen Lernfortschritt!</p>
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
		</div>
		<!-- second columns -->
		<div class="col-xs-12 col-sm-6 col-md-4">
			<i class="fab fa-empire"></i>
			<h3>Sleep</h3>
		</div>
		<!-- third columns -->
		<div class="col-sm-12 col-md-4">
			<i class="fas fa-chart-line"></i>
			<h3>Repeat</h3>
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
			<h2>Motiviert in drei schnellen Schritten</h2>
			<h3>So aktivierst Du in kurzer Zeit Deine Motivation zum Lernen:</h3>
			<p>1. Erkenne, was Dich persönlich motiviert und nutze diese Erkenntnis: Jeder hat bestimmte Dinge, die ihn motivieren. Bei dem einen ist es Lob durch andere, beim anderen Geld, beim dritten eine schwierige Herausforderung, die er meistern möchte. Wenn Du weißt, was Dich motiviert, kannst Du Dein Lernen entsprechend gestalten. Motiviert Dich beispielsweise die Anwesenheit anderer, solltest Du eine Lerngruppe gründen.</p>
			<p>2. Motiviere Dich durch Belohnungen: Bei den meisten Menschen wird die Motivation zu lernen durch Belohnungen gesteigert. Ist dies bei Dir auch der Fall, belohne Dich selbst nach Erreichen von Zwischenzielen, z. B. mit einem Kinobesuch oder einem Fußballspiel. Überlege Dir Belohnungen, die Dich wirklich zum Lernen motivieren und halte diese schriftlich fest. Betrüge Dich dabei jedoch nicht selbst. Was Du versprichst, musst Du auch halten!</p>
			<p>3. Setze Dich unter künstlichen Zeitdruck: Deine Motivation fürs Lernen kann auch durch das Schaffen von Deadlines gesteigert werden. Wird der Termindruck größer, arbeiten viele effektiver. Dies kannst Du nutzen, indem Du Dir in Deinen Kalender Deadlines für alle zu erreichenden Zwischenziele einträgst. Auch hier gilt: Betrüge Dich niemals selbst, sondern halte Dich an Deine eigenen Vorgaben!</p>
			<br>
			<h3>Bist du überzeugt? Registriere dich jetzt!</h3>
			<a class="btn btn-primary" href="register.jsp" >Registrieren</a>
		</div>
		<!-- second column -->
		<div class="col-lg-6">
			<img src="img/desk.png" class="img-fluid">
		</div>
	</div>
	<!-- horizontal rule -->
	<hr class="my-4">
</div>	

<!--- Meet the team -->

<div class="container-fluid padding">
	<div class="row welcome text-center padding">
		<div class="col-12">
			<h2>Meet the Team</h2>
		</div>
	</div>
</div>	

<!--- Cards (for the single teammembers for example) -->

<div class="container-fluid padding">
	<div class="row padding">
		<div class="col-md-3">
			<div class="card">
				<img class="card-img-top" src="img/thomas.png">
				<div class="card-body">
					<h4 class="card-title">Thomas</h4>
					<p class="card-text">Product Owner</p>
					<a href="#" class="btn btn-outline-secondary">Check Profile</a>
				</div>
			</div>			
		</div>
		<div class="col-md-3">
			<div class="card">
				<img class="card-img-top" src="img/david.png">
				<div class="card-body">
					<h4 class="card-title">David</h4>
					<p class="card-text">SCRUM-Master</p>
					<a href="#" class="btn btn-outline-secondary">Check Profile</a>
				</div>
			</div>			
		</div>
		<div class="col-md-3">
			<div class="card">
				<img class="card-img-top" src="img/marcel.png">
				<div class="card-body">
					<h4 class="card-title">Marcel</h4>
					<p class="card-text">Developer</p>
					<a href="#" class="btn btn-outline-secondary">Check Profile</a>
				</div>
			</div>			
		</div>
		<div class="col-md-3">
			<div class="card">
				<img class="card-img-top" src="img/janp.png">
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
			<h2>Noch Fragen?</h2>
			<p>Wenn ihr bei den Kursen nicht fündig werdet, Fragen zu eurem Account oder Rechnung habt wendet euch gerne und jederzeit an uns! Am einfachsten schreibst uns direkt eine Mail unter: </p>
			<p><a href="mailto:noreply.tutor24@gmail.com">noreply.tutor24@gmail.com</a></p>
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