package functions;


import java.awt.List;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
/**
 * Servlet implementation class GetProducts
 */
@WebServlet("/GetProducts")
public class GetProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// all shown rows as strings
		String courseNumber = "";
		String subject = "";
		String topic = "";
		String description = "";
		String studentType = "";
		String price = "";
		String frequency = "";
		Course course;
		String result="";
// create array list, which go into the request
		ArrayList<Course> courses = new ArrayList<>();
		try {
//	create database connection
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wip", "root", "");
            Statement statement = myConn.createStatement();
// make sql statement
            ResultSet rs = statement.executeQuery("select * from courses;");
            
// fill the arraylist with rownames
            	courseNumber = "KursID";
            	subject = "Fach";
            	topic = "Thema";
            	description = "Beschreibung";
            	studentType = "Student/ Schüler";
            	price = "Preis";
            	frequency = "Frequenz";	
            	result += courseNumber+subject+topic+description+studentType+price+frequency+"\n";
            	course = new Course(courseNumber, subject, topic, description, studentType, price, frequency);
            	courses.add(course);
            	
// fill the arraylist with the return of the sql-statement
            while (rs.next()){
            	
            	courseNumber = rs.getString("courseid");
            	subject = rs.getString("subject");
            	topic = rs.getString("topic");
            	description = rs.getString("description");
            	studentType = rs.getString("studentType");
            	price = rs.getString("pricePerHour");
            	frequency = rs.getString("frequency");
            	result += courseNumber+subject+topic+description+studentType+price+frequency+"\n";
            	course = new Course(courseNumber, subject, topic, description, studentType, price, frequency);
            	
            	courses.add(course);
            }
// write the arraylist into the request as attribute to get this on the jsp site
            request.setAttribute("courses", courses);
            request.setAttribute("result", result);
            request.getRequestDispatcher("/adminKursuebersicht.jsp").forward(request, response);
            
        }
// exception handling
        catch (Exception e) {
            System.out.println("error"+e.getMessage());
            System.out.println(e.getStackTrace());
            
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
