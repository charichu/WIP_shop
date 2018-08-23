<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%! String nav = "includes/start.jsp"; %>
<%!	String result="test"; %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administrator Seite</title>
<link href = "style.css" rel = "stylesheet">
</head>
<body>
	<div id = "wrapper">
	<%
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wip", "root", "");
                        Statement statement = myConn.createStatement();

                        ResultSet rs = statement.executeQuery("select * from user");
                        while (rs.next()){
                        	result += rs.getString("firstName") + "    " + rs.getString("lastName")+"\n";
                            System.out.println(rs.getString("firstName") + "    " + rs.getString("lastName"));
                        }
                    }
                    catch (Exception ex) {
                        System.out.println("error");
                    }
      %>
		<form action=""></form>
			<input id= "test" type="text" value = <%= result%>>
		<div id = "adminMenu">
			<div class="adminButton"><a href = ""><span>Kurse Übersicht</span></a></div>
			<div class="adminButton"><a href = ""><span>Accounts Übersicht</span></a></div>
			<div class="adminButton"><a href = ""><span>Statistiken</span></a></div>
			<div class="adminButton"><a href = "masterpage.jsp"><span>Zurück zur Startseite</span></a></div>
		</div>
		<div id = "adminContent">
		</div>
	</div>
</body>
</html>

