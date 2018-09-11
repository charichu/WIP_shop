package cartFunctions;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;

/**
 * Servlet implementation class HinzufügenWarenkorb
 */
@WebServlet("/PutInCart")
public class PutInCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutInCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * This method put a course in the cart.
	 * @return "errorMessage" or "successMessage" as attributes of the request Parameter
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get cart from session, if null create new Hashmap cart
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer> cart = (request.getSession().getAttribute("cart")!=null)?
										 (HashMap<Integer, Integer>)request.getSession().getAttribute("cart"):
										 new HashMap<Integer,Integer>();
										 
		Integer courseID = (request.getParameter("courseID")!=null)?Integer.parseInt(request.getParameter("courseID")):null;
		Integer numberOfCourse = (request.getParameter("numberOfCourse")!=null)?Integer.parseInt(request.getParameter("numberOfCourse")):null;
		
		if(courseID!=null && !cart.containsKey(courseID)){
			if(numberOfCourse!=null){
				cart.put(courseID, numberOfCourse);
			}
			else {
				request.setAttribute("errorMessage", "Die Anzahl wurde nicht befüllt, der Kurs konnte nicht in den Warenkorb gelegt werden.");
				request.getRequestDispatcher("GetCourses").forward(request, response);
			}
			request.setAttribute("successMessage", "Der Kurs wurde erfolgreich in den Warenkorb gelegt.");
			request.getRequestDispatcher("GetCourses").forward(request, response);
		}
		else if(courseID==null){
			request.setAttribute("errorMessage", "Die KursID wurde nicht befüllt, es konnte kein Kurs in den Warenkorb gelegt werden.");
			request.getRequestDispatcher("GetCourses").forward(request, response);
		}
		else {
			request.setAttribute("errorMessage", "Dieser Kurs wurde schon in den Warenkorb gelegt");
			request.setAttribute("courseID", courseID);
			request.getRequestDispatcher("DisplayCourseDetails").forward(request, response);
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
