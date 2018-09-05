package functions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Servlet implementation class DisplayDetails
 */
@WebServlet("/DisplayDetails")
public class DisplayDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int courseID;
		String sqlStatement;
		Hashtable<String, String> course = new Hashtable<>();
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wip", "root", "");
            Statement statement = myConn.createStatement();
            courseID = Integer.parseInt(request.getParameter("courseID"));
            
            sqlStatement  =	"SELECT * "
            			+ 	"FROM addresses a, courses c, user u "
            			+ 	"WHERE a.addressID = c.addressID "
            			+ 	  " AND c.courseID = "+courseID
            			+	  " AND u.userID   = c.userID;";
            ResultSet rs = statement.executeQuery(sqlStatement);
            
			if(rs.next() && rs.isLast()){
				 course.put("plz", rs.getString("plz"));
				 course.put("city", rs.getString("city"));
				 course.put("street", rs.getString("street"));
				 course.put("houseNumber", rs.getString("houseNumber"));
				 course.put("courseID", rs.getString("courseID"));
				 course.put("subject", rs.getString("subject"));
				 course.put("topic", rs.getString("topic"));
				 course.put("description", (rs.getString("description")==null)?"":rs.getString("description"));
				 course.put("studentType", (rs.getString("studentType")==null)?"":rs.getString("studentType"));
				 course.put("pricePerHour", (rs.getString("pricePerHour")==null)?"":rs.getString("pricePerHour"));
				 course.put("capacity", (rs.getString("capacity")==null)?"":rs.getString("capacity"));
				 course.put("frequency", (rs.getString("frequency")==null)?"":rs.getString("frequency"));
				 course.put("durationPerMeeting", (rs.getString("durationPerMeeting")==null)?"":rs.getString("durationPerMeeting"));
				 course.put("grade", rs.getString("grade"));
				 course.put("firstName", rs.getString("firstName"));
				 course.put("lastName", rs.getString("lastName"));
				 course.put("qualificationProfile", rs.getString("qualificationProfile"));
				 request.setAttribute("courseDetails", course);
			}
			request.getRequestDispatcher("/KursDetails.jsp").forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/KursDetails.jsp").forward(request, response);
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
