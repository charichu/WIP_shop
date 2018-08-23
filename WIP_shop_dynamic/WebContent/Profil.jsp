<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Profil</title>
	<!-- Imports -->
	<div><jsp:include page="includes/imports.jsp"/></div>
</head>
<body>

<!-- Navigation and Login -->
<div><jsp:include page="includes/navigation.jsp"/></div>

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

<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>