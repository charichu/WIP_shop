package courseFunctions;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import functions.DBFunctions;
/**
 * Servlet implementation class GetMyCourses
 */
@WebServlet("/GetMyCourses")
public class GetMyCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMyCourses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer userID = (Integer) request.getSession().getAttribute("userId");
		Integer userType = (Integer) request.getSession().getAttribute("userType");
		boolean userLoggedIn = request.getSession().getAttribute("userLoggedIn")!=null?(Boolean)request.getSession().getAttribute("userLoggedIn"):false;
		ArrayList<Course> courses = new ArrayList<Course>();
		Integer tempCourseID;
		String sqlStatement;
		if(userLoggedIn&&userID!=null&&userType!=null){
			if (userType==1) {
				sqlStatement=DBFunctions.CreateSelectQuery("courses", new String[]{"courseID"}, "userID = "+userID.toString());
				
				try {
					ResultSet rs = DBFunctions.Execute(sqlStatement);
					courses.add(new Course());
					while (rs.next()) {
						courses.add(new Course(rs.getInt("courseID")));
					}
				} catch (Exception e) {
					request.setAttribute("errorMessage", e.getMessage());
					request.getRequestDispatcher("home.jsp").forward(request, response);
				}
				
				request.setAttribute("myCourses", courses);
				request.getRequestDispatcher("MeineKurse.jsp").forward(request, response);
			} else if(userType==2){
				sqlStatement=DBFunctions.CreateSelectQuery("orders o, orderItems oi", new String[]{"oi.courseID"}, "o.orderID = oi.orderID AND userID = "+userID.toString());
				
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
