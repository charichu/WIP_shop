package courseFunctions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditCourse
 */
@WebServlet("/EditCourse")
public class EditCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer courseID = Integer.parseInt(request.getParameter("courseID"));
		String subject= request.getParameter("txtSubject");
		String description = request.getParameter("txtDescription");
		String studentType = request.getParameter("txtStudentType");
		Double pricePerHour = Double.parseDouble(request.getParameter("txtPricePerHour"));
		Integer capacity = (int)Double.parseDouble(request.getParameter("txtCapacity"));
		String frequency    = request.getParameter("txtFrequency");
		Double durationPerMeeting =Double.parseDouble(request.getParameter("txtDurationPerMeeting"));
		Integer durationPerMeetingInt = (int)Math.round(durationPerMeeting);
		Integer grade = Integer.parseInt(request.getParameter("txtGrade"));
		Integer plz = Integer.parseInt(request.getParameter("txtPLZ"));
		String city = request.getParameter("txtCity");
		String street = request.getParameter("txtStreet");
		Integer houseNumber = Integer.parseInt(request.getParameter("txtHouseNumber"));
		Integer addressID   = Integer.parseInt(request.getParameter("addressID"));
		String sqlStatement;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
	        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wip", "root", "");
	        sqlStatement="UPDATE `courses` SET `subject` = '"+subject+"', `description` = '"+description+"', `studentType`='"+studentType+"', `pricePerHour`=? , `capacity`= ? ,`frequency`='"+frequency+"', `durationPerMeeting`= ? , `grade` = ? WHERE `courses`.`courseID` = "+courseID+";";
	        PreparedStatement ps = myConn.prepareStatement(sqlStatement);
	        ps.setDouble(1, pricePerHour);
	        ps.setDouble(2, capacity.doubleValue());
	        ps.setDouble(3, durationPerMeeting.doubleValue());
	        ps.setInt(4, grade);
	        ps.executeUpdate();
        	
        	sqlStatement="UPDATE `addresses` SET `plz`='"+plz+"',`city`='"+city+"', `street`='"+street+"', `housenumber` = ? WHERE `addresses`.`addressID`="+addressID+";"; 
        	ps=myConn.prepareStatement(sqlStatement);
        	ps.setInt(1, houseNumber);
        	ps.executeUpdate();
        	
	        request.setAttribute("successMessage", "Kurs erfolgreich bearbeitet");
	        request.getRequestDispatcher("GetMyCourses").forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
