package cartFunctions;


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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import courseFunctions.Course;
/**
 * Servlet implementation class GetProducts
 */
@WebServlet("/GetCart")
public class GetCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * This method will give the cart of the user.
	 * @return {@link ArrayList} filled with {@link Course}, which are in the cart
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
		String grade = "";
		Course course;
		String result="";
		String targetSite = request.getParameter("targetSite");
		String sqlStatement="";
// Get the Cart from the session, if the cart is null set create a new Hashmap as cart
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer> cart = (request.getSession().getAttribute("cart")!=null)
										 ?(HashMap<Integer, Integer>)request.getSession().getAttribute("cart")
										 :new HashMap<Integer,Integer>();
		
		
// create array list, which go into the request
		ArrayList<Course> cartList = new ArrayList<>();
		try {
			if(!cart.isEmpty()){
				
//	create database connection
				
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wip", "root", "");
	            Statement statement = myConn.createStatement();
// create sql statement
	            
	            sqlStatement="Select * from courses Where courseId IN (";
	            
	    		for(Integer key : cart.keySet()){
	    			sqlStatement+=key+",";
	    		}
	    		
	    		sqlStatement=sqlStatement.substring(0,sqlStatement.length()-1)+");";
	            ResultSet rs = statement.executeQuery(sqlStatement);
	            
// fill the arraylist with rownames
	            	courseNumber = "KursID";
	            	subject = "Fach";
	            	topic = "Thema";
	            	description = "Beschreibung";
	            	studentType = "Student/ Schüler";
	            	price = "Preis";
	            	frequency = "Frequenz";	
	            	grade = "Jahrgangsstufe";	
	            	course = new Course(courseNumber, subject, topic, description, studentType, price, frequency,grade);
	            	cartList.add(course);
	            	
// fill the arraylist with the return of the sql-statement
	            while (rs.next()){
	            	
	            	courseNumber = rs.getString("courseid");
	            	subject = rs.getString("subject");
	            	topic = rs.getString("topic");
	            	description = rs.getString("description");
	            	studentType = rs.getString("studentType");
	            	price = rs.getString("pricePerHour");
	            	frequency = rs.getString("frequency");
	            	grade = rs.getString("grade");
	            	course = new Course(courseNumber, subject, topic, description, studentType, price, frequency, grade);
	            	
	            	cartList.add(course);
	            }
// write the arraylist into the request as attribute to get this on the jsp site
	            request.setAttribute("cart", cartList);
			}
            request.getRequestDispatcher("/Warenkorb.jsp").forward(request, response);
            
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
