package courseFunctions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import functions.Address;

/**
 * Servlet implementation class EditCourse
 */
@WebServlet("/GetEditCourse")
public class GetEditCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEditCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer courseID = request.getParameter("courseID")!=null?Integer.parseInt(request.getParameter("courseID")):null;
		if(courseID==null){
			request.setAttribute("errorMessage", "Es konnte kein Kurs zum Bearbeiten gefunden werden!");
			request.getRequestDispatcher("GetMyCourses").forward(request, response);
		}
		else{
			Course course = new Course(courseID);
			if (!course.isEmpty()) {
				Address address = course.getAddress();
				request.setAttribute("address", address);
				request.setAttribute("course", course);
				request.getRequestDispatcher("KursBearbeiten.jsp").forward(request, response);
			}
			else {
				request.setAttribute("errorMessage", "Es konnte kein Kurs zum Bearbeiten gefunden werden!");
				request.getRequestDispatcher("GetMyCourses").forward(request, response);
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
