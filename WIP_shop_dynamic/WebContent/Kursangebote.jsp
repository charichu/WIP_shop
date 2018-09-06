<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import = "functions.Course" %>
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

<!-- Product View  -->
<!-- Product View  -->
<!-- Product View  -->

<div class="container">
	<div class="well well-sm">
		<strong>Gefundene Kurse</strong>
			<div class="btn-group">
				<a href="#" id="list" class="btn btn-default btn-sm">
					<span class="glyphicon glyphicon-th-list">
					</span>Listenansicht</a> 
				<a href="#" id="grid" class="btn btn-default btn-sm">
					<span class="glyphicon glyphicon-th">
					</span>Rasteransicht</a>
			</div>		
	</div>
	<script> 
	// <!-- Choose Grid or List View -->
	$(document).ready(function() {
	    $('#list').click(function(event){event.preventDefault();$('#divProducts .item').addClass('list-group-item');});
	    $('#grid').click(function(event){event.preventDefault();$('#divProducts .item').removeClass('list-group-item');$('#divProducts .item').addClass('grid-group-item');});
	});
	</script>
	<!-- Container where all the products end up -->
	<div  id="divProducts" class="row list-group">
<% 
	ArrayList<Course> list = (ArrayList<Course>) request.getAttribute("courses");
		if(!(list == null)){
%>
	<%-- display the products --%>			
		<% 	list.remove(0);
			for(Course course:list){%>	
			
				<div class="item col-xs-4 col-lg-4">
				<!-- Product picture -->
					<div class="thumbnail">
						<img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt="" />
						<div class="caption">
							<!-- Product title -->
							<h4 class="group inner list-group-item-heading">
								<%out.println(course.getTopic()); %>
							</h4>
								<!-- Product Tooltip -->
								<p class="group-inner list-group-item-text">
									<%out.println(course.getDescription()); %>
								</p>
							<div class="row">
								<div class="col-xs-12 col-md-6">
								<!-- Product Price -->
								<p class="lead">
									<%out.println(course.getPrice()); %>
								</p>
							</div>
						<!-- Jump to Detailed View -->
						<div class="col-xs-12 col-md-6">
							<a class="btn btn-success" href="DisplayDetails?courseID=<%=course.getCouseNumber()%>">Details</a>	
						</div>
					</div>
				</div>
			</div>
		</div>
		<%  	}
			}%>
	</div>
</div>

<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>