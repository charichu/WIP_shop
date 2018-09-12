package profile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String username, email, firstName, lastName, qualificationProfile, street, city, plz, grade, dateOfbirth, sqlStatement, houseNumber, addressID;
			email    = request.getParameter("txtEmail");
			lastName= request.getParameter("txtLastName");
			qualificationProfile= request.getParameter("txtQualificationProfile");
			street  = request.getParameter("txtStreetHousenumber").substring(0,request.getParameter("txtStreetHousenumber").lastIndexOf(" "));
			houseNumber = request.getParameter("txtStreetHousenumber").substring(request.getParameter("txtStreetHousenumber").lastIndexOf(" ")+1);
			city  = request.getParameter("txtCity");
			plz  = request.getParameter("txtPlz");
			grade  = request.getParameter("txtGrade");
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
	        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wip", "root", "");
	        sqlStatement="UPDATE `user` SET `email` = '"+email+"', `lastName` = '"+lastName+"', `class` = ? , `qualificationProfile` = ? WHERE `user`.`userID` = "+request.getSession().getAttribute("userId")+";";
	        PreparedStatement ps = myConn.prepareStatement(sqlStatement);
	        if(grade==null){
	        	ps.setString(1, "");
	        }
	        else {
				ps.setString(1, grade);
			}
	        if (qualificationProfile==null) {
	        	ps.setString(2, "");
			}
	        else {
				ps.setString(2, qualificationProfile);
			}
	        
	        ps.executeUpdate();
	        ps=myConn.prepareStatement("SELECT * FROM user WHERE userID = "+request.getSession().getAttribute("userId"));
	        ResultSet rs=ps.executeQuery();
	        if(rs.next()){
	        	addressID=rs.getString("addressID");
	        	sqlStatement="UPDATE `addresses` SET `plz`='"+plz+"',`city`='"+city+"', `street`='"+street+"', `housenumber` = ? WHERE `addresses`.`addressID`="+addressID+";"; 
	        	ps=myConn.prepareStatement(sqlStatement);
	        	ps.setInt(1, Integer.parseInt(houseNumber));
	        	ps.executeUpdate();
	        }
	        request.setAttribute("successMessage", "Profil erfolgreich bearbeitet");
	        request.getRequestDispatcher("GetProfile").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());;
			request.getRequestDispatcher("GetProfile").forward(request, response);
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
