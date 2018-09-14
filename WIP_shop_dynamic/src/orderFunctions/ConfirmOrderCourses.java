package orderFunctions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartFunctions.PdfInvoice;
import courseFunctions.Course;
import functions.DBFunctions;
import functions.Email;
import functions.User;
/**
 * Servlet implementation class OrderCourses
 */
@WebServlet("/ConfirmOrderCourses")
public class ConfirmOrderCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmOrderCourses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("userLoggedIn")!=null&&(Boolean)request.getSession().getAttribute("userLoggedIn")==true){
			if((Integer)request.getSession().getAttribute("userType")==1){
				request.setAttribute("errorMessage", "Bitte loggen sie sich als Schüler ein.");
				request.getRequestDispatcher("GetCart").forward(request, response);
			}
			else {
				try {
					Date currentDate = new Date(System.currentTimeMillis());
					Time currentTime = new Time(System.currentTimeMillis());
					User currentUser = new User((Integer)request.getSession().getAttribute("userId"));
					ArrayList<Course> bookingList = request.getSession().getAttribute("bookingList")!=null?
													(ArrayList<Course>)request.getSession().getAttribute("bookingList"):new ArrayList<Course>();
					HashMap<Integer, Integer> cart = (request.getSession().getAttribute("cart")!=null)?
													 (HashMap<Integer, Integer>)request.getSession().getAttribute("cart"):
													 new HashMap<Integer,Integer>();
					Double sum = request.getAttribute("sum")!=null?
								 (Double)request.getAttribute("sum"):0;
					Integer userID = (Integer)request.getSession().getAttribute("userId");
					String[] columnNames = new String[]{"orderDate", "time", "totalPrice", "userID"};
					String[] columnValues = new String[]{"'"+currentDate.toString()+"'", "'"+currentTime.toString()+"'", "'"+sum.toString()+"'", "'"+userID.toString()+"'"};
					Double subTotal;
					
					Class.forName("com.mysql.jdbc.Driver").newInstance();
			        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wip", "root", "");
			        Statement statement=myConn.createStatement();
			        myConn.setAutoCommit(false);
			        String sqlStatement=DBFunctions.CreateInsertQuery("orders", columnNames,  columnValues);
			        sqlStatement=sqlStatement+";";
			        PreparedStatement ps = myConn.prepareStatement(sqlStatement, statement.RETURN_GENERATED_KEYS);
			        ps.executeUpdate();
			        ResultSet rs = ps.getGeneratedKeys();
			        Integer orderID = null;
			        
			        if (rs.next()) {
			        	orderID=rs.getInt(1);
					}
			        columnNames = new String[]{"subTotal", "courseID", "orderID", "numberOfCourses","pricePerMeeting"};
			        
			        for(Course course:bookingList){
			        	subTotal=cart.get(Integer.parseInt(course.getCourseNumber()))*course.getPricePerMeeting();
			        	columnValues = new String[]{"'"+subTotal.toString()+"'","'"+course.getCourseNumber()+"'", "'"+orderID.toString()+"'","'"+cart.get(Integer.parseInt(course.getCourseNumber())).toString()+"'","'"+course.getPricePerMeeting().toString()+"'"};
			        	sqlStatement=DBFunctions.CreateInsertQuery("order_items", columnNames, columnValues);
			        	ps = myConn.prepareStatement(sqlStatement);
			        	ps.executeUpdate();
			        }
			       
			        String mailText = "Sehr geehrte/r " +currentUser.getFirstName()+" "+currentUser.getLastName()+"\n"+
			        				  "wir vom Tutor24 Shop bedanken uns f�r Ihre Bestellung �ber unser Portal.\r\n"+
			        				  "an dieser E-Mail finden Sie die Rechnung, die Sie innerhalb von 14 Tagen überweisen müssen."+
			        				  "alles weitere zu unseren Zahlungsbedingungen finden Sie in unseren AGB's \r\n"+
			        				  "Ihr Team von Tutor24";			        
			        if(Email.IsValid(currentUser.getEmail())){
			        	PdfInvoice.print(bookingList, cart, sum, orderID, request);
			        	String absolutePath = new String ("C://xampp//Invoice_" + orderID + ".pdf");
			        	Email orderMail = new Email(currentUser.getEmail(), "Tutor24: Rechnung für Bestellung "+orderID.toString(), mailText, absolutePath);
			        	if(orderMail.send()){
			        		request.setAttribute("successMessage", "Die Bestellung wurde erfolgreich abgeschlossen.");
							request.getSession().removeAttribute("cart");
							request.getSession().removeAttribute("bookingList");
							myConn.commit();
							myConn.close();
							request.getRequestDispatcher("home.jsp").forward(request,response);
			        	}
			        	else {
			        		request.setAttribute("errorMessage", "Die E-Mail konnte leider nicht versandt werden");
//							myConn.rollback();
			        		myConn.commit();
							myConn.close();
							request.getRequestDispatcher("home.jsp").forward(request,response);
						}
			        	
			        }
			        else{
			        	request.setAttribute("errorMessage", "Ihre E-Mail ist nicht korrekt.");
			        	myConn.rollback();
			        	myConn.close();
			        	request.getRequestDispatcher("GetCart").forward(request,response);
			        }

			        
				}catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
					request.setAttribute("errorMessage", "Folgender Fehler ist aufgetreten: "+e.getMessage());
					request.getRequestDispatcher("GetCart").forward(request,response);
				}
				
			}
			
		}
		else {
			request.setAttribute("errorMessage", "Bitte loggen sie sich ein oder registrieren sie sich.");
			request.getRequestDispatcher("GetCart").forward(request, response);
		}
		
		
	}

}
