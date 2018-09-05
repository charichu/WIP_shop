package cartFunctions;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCourseFromCart
 */
@WebServlet("/DeleteCourseFromCart")
public class DeleteCourseFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCourseFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<Integer, Integer> cart = (request.getSession().getAttribute("cart")!=null)?
										 (HashMap<Integer, Integer>)request.getSession().getAttribute("cart"):
										 new HashMap<Integer,Integer>();
		Integer courseID = (request.getParameter("courseID")!=null)?Integer.parseInt(request.getParameter("courseID")):null;
		if (!cart.isEmpty()) {
			if (courseID!=null && cart.containsKey(courseID)) {
				cart.remove(courseID);
				request.getSession().removeAttribute("cart");
				request.setAttribute("successMessage", "Der Kurs mit der Nummer "+courseID+" wurde erfolgreich aus Ihrem Warenkorb gelöscht");
				request.getSession().setAttribute("cart",cart);
			}
			else if(courseID==null){
				request.setAttribute("errorMessage", "Die KursID ist nicht gefüllt");
			}
			else{
				request.setAttribute("errorMessage", "Dieser Kurs wurde schon gelösch bitte aktualisieren sie die Seite.");
			}
		}
		else {
			request.setAttribute("errorMessage", "Der Warenkorb ist leer, deswegen können sie keinen Kurs löschen");
		}
		request.getRequestDispatcher("GetCart").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
