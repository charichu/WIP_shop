package cartFunctions;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>)request.getSession().getAttribute("cart");
		int courseID = Integer.parseInt(request.getParameter("courseID"));
		
		if(!cart.containsKey(courseID)){
			cart.put(courseID, 0);
			request.setAttribute("successMessage", "Der Kurs wurde erfolgreich in den Warenkorb gelegt.");
			request.getRequestDispatcher("GetCourses").forward(request, response);
		}
		else {
			request.setAttribute("errorMessage", "Dieser Kurs wurde schon in den Warenkorb gelegt");
			request.setAttribute("courseID", courseID);
			request.getRequestDispatcher("DisplayDetails").forward(request, response);
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
