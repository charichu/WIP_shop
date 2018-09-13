package courseFunctions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import functions.DBFunctions;
/**
 * Servlet implementation class DeleteCourse
 */
@WebServlet("/DeleteCourse")
public class DeleteCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer courseID= Integer.parseInt(request.getParameter("courseID"));
		String target = request.getParameter("target");
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
	        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wip", "root", "");
			String sqlStatement = "UPDATE `courses` SET `active` = '0' WHERE `courses`.`courseID` = "+courseID+";";
			PreparedStatement ps = myConn.prepareStatement(sqlStatement);
			ps.executeUpdate();
			request.getRequestDispatcher(target).forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
