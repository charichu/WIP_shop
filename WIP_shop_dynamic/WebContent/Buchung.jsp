<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import = "courseFunctions.Course" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Buchung</title>
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
			<h2 class="display-4">Bestellungsübersicht</h1>
			<% ArrayList<Course> bookingList = (request.getAttribute("bookingList")!=null)
											   ?(ArrayList<Course>) request.getAttribute("bookingList"):new ArrayList<Course>();
			   if(!bookingList.isEmpty()){
			   HashMap<Integer,Integer> cart=(session.getAttribute("cart")!=null)?
						   					  (HashMap<Integer,Integer>)session.getAttribute("cart"):
						   					  new HashMap<Integer,Integer>();
			   Integer number;%>
			<%-- display the products in the table --%>
			<table>
				<tr>
					<th><%out.println(bookingList.get(0).getSubject()); %></th>
					<th><%out.println(bookingList.get(0).getDescription()); %></th>
					<th><%out.println(bookingList.get(0).getStudentType()); %></th>
					<th><%out.println(bookingList.get(0).getCapacityDescription()); %></th>
					<th><%out.println(bookingList.get(0).getFrequency()); %></th>
					<th><%out.println(bookingList.get(0).getGrade()); %></th>
					<th><%out.println(bookingList.get(0).getDurationPerMeetingDescription()); %></th>
					<th><%out.println(bookingList.get(0).getPricePerHour()); %></th>
					<th><%out.println("Preis pro Treffen"); %></th>
					<th><%out.println("Anzahl"); %></th>
					<th><%out.println("Kosten Gesamt"); %></th>
	
				</tr>
				<% 		bookingList.remove(0);
						for(Course course:bookingList){
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
					<td><%out.println(number); %></td>
					<td><%out.println(number*course.getPricePerMeeting()); %></td>
				</tr>
			
			<%  		}%>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td colspan="9"></td>
					<th colspan="1">Summe:</td>
					<td><%out.println(request.getAttribute("sum")); %></td>
				</tr>
			</table>
			<%}
			else{%>
				Ihre Buchung wurde nicht befüllt.
			<%
			}%>
		</div>
		<div class="col-4">
			<form id="" action="">
				<input type="submit" value="Bestellung bestätigen" class="nav-link">
			</form>
		</div>
	</div>
</div>	
<!--- Footer -->
<div><jsp:include page="includes/footer.jsp"/></div>

</body>
</html>