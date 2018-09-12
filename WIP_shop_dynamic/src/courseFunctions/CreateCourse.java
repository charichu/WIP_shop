package courseFunctions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.sun.xml.internal.ws.wsdl.writer.document.Types;

/**
 * Servlet implementation class CreateCourse
 */
@WebServlet("/CreateCourse")
public class CreateCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  subject=null, topic=null, description=null,
				studentType=null, frequency=null, streetHouseNumber=null, city=null, sqlStatement=null;
		Double  pricePerHour=null, durationPerMeeting=null;
		Integer plz=null, capacity=null, grade=null, userId=null, addressID=null;
		Integer userType = (Integer)request.getSession().getAttribute("userType");
		request.setCharacterEncoding("UTF-8");
		Boolean isAdmin=false;
		subject 			= request.getParameter("txtSubject");
		topic				= "";
		description 		= request.getParameter("txtDescription");
		studentType 		= request.getParameter("txtStudentType");
		frequency 			= request.getParameter("txtFrequency");
		streetHouseNumber 	= request.getParameter("txtStreetHouseNumber");
		city 				= request.getParameter("txtCity");
		pricePerHour 		= Double.parseDouble(request.getParameter("txtPricePerHour"));
		durationPerMeeting	= (request.getParameter("txtDurationPerMeeting")!="")?Double.parseDouble(request.getParameter("txtDurationPerMeeting")):null;
		capacity 			= (request.getParameter("txtCapacity")!="")?Integer.parseInt(request.getParameter("txtCapacity")):null;
		plz 				= (request.getParameter("txtPLZ")!="")?Integer.parseInt(request.getParameter("txtPLZ")):null;
		grade 				= (request.getParameter("txtGrade")!="")?Integer.parseInt(request.getParameter("txtGrade")):null;
		
		isAdmin= (request.getParameter("txtUserId")!=""&&userType==0)? true : false;
		userId = isAdmin? Integer.parseInt(request.getParameter("txtUserId")): (Integer)request.getSession().getAttribute("userId");
		try {
			ResultSet rs;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
	        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wip", "root", "");
	        Statement statement=myConn.createStatement();
	        sqlStatement = 	"INSERT INTO `addresses` (`plz`, `city`, `street`, `housenumber`, `addressID`) "
	        		+ 		"VALUES ('"+plz+"','"+city+"','"+streetHouseNumber.substring(0, streetHouseNumber.indexOf(" "))
	        		+				"','"+streetHouseNumber.substring(streetHouseNumber.indexOf(" ")+1)+"', NULL);";
	        PreparedStatement ps = myConn.prepareStatement(sqlStatement, statement.RETURN_GENERATED_KEYS);
	        ps.executeUpdate();
	        rs=ps.getGeneratedKeys();
	        while (rs.next()) {
				addressID=rs.getInt(1);
			}
	        sqlStatement = "INSERT INTO `courses` "
	        		+ "					(`courseID`, `subject`, `topic`,"
	        		+ "					 `description`, `studentType`, `pricePerHour`,"
	        		+ "					 `capacity`, `frequency`, `durationPerMeeting`,"
	        		+ "					 `addressID`, `grade`, `userID`) "
	        		+ "		VALUES 	(NULL,?, ?,?,?,?,?,?,?,?,?,?);";
	        ps = myConn.prepareStatement(sqlStatement);
	        ps.setString(1, subject);
	        ps.setString(2, topic);
	        ps.setString(3, description);
	        ps.setString(4, studentType);
	        ps.setDouble(5, pricePerHour);
	        if(capacity!=null){
	        	ps.setDouble(6, capacity);
        	}
	        else{
	        	ps.setNull(6, java.sql.Types.DOUBLE);
        	}
        	ps.setString(7, frequency);
        	
	        if(durationPerMeeting!=null){
	        	ps.setDouble(8, durationPerMeeting);}
	        else {
	        	ps.setNull(8, java.sql.Types.DOUBLE);
			}
	        ps.setInt(9, addressID);
	        if(grade!=null){
	        	ps.setDouble(10, grade);}
	        else {
	        	ps.setNull(10, java.sql.Types.INTEGER);
			}
	        if(userId!=null){
	        	ps.setInt(11, userId);}
	        else {
	        	ps.setNull(11, java.sql.Types.INTEGER);
			}
	        ps.executeUpdate();
	        myConn.close();
	        request.getRequestDispatcher("/MeineKurse.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("error "+e.getMessage());
			for(StackTraceElement elem : e.getStackTrace()){
				System.err.println(elem);
			}
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
