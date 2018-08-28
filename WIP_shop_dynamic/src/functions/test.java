package functions;
import java.io.PrintWriter;

import java.sql.*;
import javax.servlet.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class test {

	public static void main(String[] args) {
		String courseNumber = "";
		String subject = "";
		String topic = "";
		String description = "";
		String studentType = "";
		String price = "";
		String frequency = "";
		Course course;
		ArrayList<Course> courses = new ArrayList<>();
		/*try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wip", "root", "");
            Statement statement = myConn.createStatement();

            ResultSet rs = statement.executeQuery("select * from kurs");
            result += "<table id = 'products'>\n"+
            			 	"<tr>\n"+
	            			 	"<th>KursNummer</th>\n"+
	            			 	"<th>Fach</th>\n"+
	            			 	"<th>Thema</th>\n"+
	            			 	"<th>Beschreibung</th>\n"+
	            			 	"<th>Schüler/student</th>\n"+
	            			 	"<th>Preis</th>\n"+
	            			 	"<th>Frequenz</th>\n"+
            			 	"</tr>";
            while (rs.next()){
            	result +="<tr>\n";
            	result += "<td>"+rs.getString("courseid")+"</td>\n"+
            			"<td>"+rs.getString("subject")+"</td>\n"+
            			"<td>"+rs.getString("topic")+"</td>\n"+
            			"<td>"+rs.getString("description")+"</td>\n"+
            			"<td>"+rs.getString("studentType")+"</td>\n"+
            			"<td>"+rs.getString("pricePerHour")+"</td>\n"+
            			"<td>"+rs.getString("frequency")+"</td>\n";
            	result +="</tr>\n";
            }
            result +="</table>\n";
            System.out.println(result);
        }*/
		try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wip", "root", "");
            Statement statement = myConn.createStatement();

            ResultSet rs = statement.executeQuery("select * from kurs");
            	courseNumber = "KursID";
            	subject = "Fach";
            	topic = "Thema";
            	description = "Beschreibung";
            	studentType = "Student/ Schüler";
            	price = "Preis";
            	frequency = "Frequenz";	
            	course = new Course(courseNumber, subject, topic, description, studentType, price, frequency);
            	courses.add(course);
            while (rs.next()){
            	
            	courseNumber = rs.getString("courseid");
            	subject = rs.getString("subject");
            	topic = rs.getString("topic");
            	description = rs.getString("description");
            	studentType = rs.getString("studentType");
            	price = rs.getString("pricePerHour");
            	frequency = rs.getString("frequency");
            	
            	course = new Course(courseNumber, subject, topic, description, studentType, price, frequency);
            	
            	courses.add(course);
            }
        }
        catch (Exception ex) {
            System.out.println("error");
        }
	}
}
