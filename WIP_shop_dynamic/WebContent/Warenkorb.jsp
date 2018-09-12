<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import = "courseFunctions.Course" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Warenkorb</title>
	<!-- Imports -->
	<div><jsp:include page="includes/imports.jsp"/></div>
	<div><jsp:include page="includes/scripts.jsp"/></div>
</head>
<body>

<!-- Navigation and Login -->
<div><jsp:include page="includes/navigation.jsp"/></div>	

<%-- Variable Declaration --%>

<div class="container-fluid padding">
	<div class="row">
		<div class="col-8">
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
			<h1 class="display-4">Warenkorb</h1>
			<%
			ArrayList<Course> cartList = (ArrayList<Course>) request.getAttribute("cart");
			if(!(cartList == null)){
				@SuppressWarnings("unchecked") 
				HashMap<Integer,Integer> cart=(session.getAttribute("cart")!=null)?
						   					  (HashMap<Integer,Integer>)session.getAttribute("cart"):
						   					  new HashMap<Integer,Integer>();
				Integer number;
			%>
			<%-- display the products in the table --%>
			<table>
				<tr>
					<th><%out.println(cartList.get(0).getSubject()); %></th>
					<th><%out.println(cartList.get(0).getDescription()); %></th>
					<th><%out.println(cartList.get(0).getStudentType()); %></th>
					<th><%out.println(cartList.get(0).getCapacityDescription()); %></th>
					<th><%out.println(cartList.get(0).getFrequency()); %></th>
					<th><%out.println(cartList.get(0).getGrade()); %></th>
					<th><%out.println(cartList.get(0).getDurationPerMeetingDescription()); %></th>
					<th><%out.println(cartList.get(0).getPricePerHour()); %></th>
					<th><%out.println("Preis pro Treffen"); %></th>
					<th><%out.println("Anzahl"); %></th>
					<th rowspan="2"></th>
	
				</tr>
				<% 		cartList.remove(0);
						for(Course course:cartList){
						number=cart.get(Integer.parseInt(course.getCourseNumber()));%>
				
				<tr>
					
						<td><%out.println(course.getSubject()); %></td>
						<td><%out.println(course.getDescription()); %></td>
						<td><%out.println(course.getStudentType()); %></td>
						<td><%out.println(course.getCapacity()); %></td>
						<td><%out.println(course.getFrequency()); %></td>
						<td><%out.println(course.getGrade()); %></td>
						<td><%out.println(course.getDurationPerMeeting()); %></td>
						<td><%out.println(course.getPricePerHour()); %></td>
						<td><%out.println(course.getPricePerMeeting()); %></td>
						<td><input type="text" name="txt<%=course.getCourseNumber()%>" value="<%=number%>" pattern="[0-9]{1,}" required="required" form="BookCourses" size="1"></td>
						<td><a class="nav-link" href="DisplayCourseDetails?courseID=<%=course.getCourseNumber()%>">Details</a></td>
						<td><form action="DeleteCourseFromCart">
								<input type="submit" value="löschen">
								<input type="hidden" name="courseID" value="<%=course.getCourseNumber()%>">
							</form></td>
				</tr>
			<%  		}
			}
			else{%>
				Ihr Warenkorb wurde nicht befüllt.
			<%
			}%>
			</table>
		</div>
		<div class="col-4">
			<form id="BookCourses" action="BookCourses" method="post">
				<input type="submit" value="Bestellen" class="nav-link">
			</form>
		</div>
	</div>
</div>	
<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>