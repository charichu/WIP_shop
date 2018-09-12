package cartFunctions;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import courseFunctions.Course;
/**
 * Servlet implementation class BookCourses
 */
@WebServlet("/BookCourses")
public class BookCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookCourses() {
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
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer> cart = (request.getSession().getAttribute("cart")!=null)?
										 (HashMap<Integer, Integer>)request.getSession().getAttribute("cart"):
										 new HashMap<Integer,Integer>();
		Integer number;
		Double  sum = 0.0;
		Course tempCourse;
		String parameter;
		ArrayList<Course> courseList=new ArrayList<Course>();
		for(Integer key : cart.keySet()){
			parameter="txt"+key;
			number=(request.getParameter(parameter)!=null)?Integer.parseInt(request.getParameter("txt"+key)):null;
			if(number!=null&&cart.get(key)!=number){
				cart.put(key, number);
			}
			else if(number==null){
				request.setAttribute("errorMessage", "Es wurde mindestens eine Anzahl nicht eingegeben. Bitte tragen Sie diese ein bevor Sie weitermachen");
				request.getRequestDispatcher("GetCart").forward(request, response);
				return;
			}
		}
		try {
			//get all courses by courseID's
			tempCourse = new Course();
			courseList.add(tempCourse);
			for(Integer tempCourseID : cart.keySet()){
				tempCourse=new Course(tempCourseID);
				sum+=tempCourse.getPricePerMeeting()*cart.get(Integer.parseInt(tempCourse.getCourseNumber()));
				courseList.add(tempCourse);
			}
			request.setAttribute("bookingList", courseList);
			request.setAttribute("sum", sum);
			request.getRequestDispatcher("Buchung.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("errorMessage", "Es ist ein Fehler aufgetreten.");
			request.getRequestDispatcher("GetCart").forward(request, response);
		}
		
		
		
		
	}

}
