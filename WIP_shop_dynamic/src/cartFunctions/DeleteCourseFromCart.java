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
	 * This method delete the course with the given courseID from the cart.
	 * @return request attribute "successMessage" is set if the delete was successful; 
	 * request attribute "errorMessage" is set if the delete was not successful
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//Get the cart Hashmap from the session
		HashMap<Integer, Integer> cart = (request.getSession().getAttribute("cart")!=null)?
										 (HashMap<Integer, Integer>)request.getSession().getAttribute("cart"):
										 new HashMap<Integer,Integer>();
//Get the courseID from the course which will be deleted from the cart
		Integer courseID = (request.getParameter("courseID")!=null)?Integer.parseInt(request.getParameter("courseID")):null;

		if (!cart.isEmpty()) {
			if (courseID!=null && cart.containsKey(courseID)) {
//If all parameters are filled and the courseID is in the cart,
//delete the course from the cart with the given courseID
				cart.remove(courseID);
				request.getSession().removeAttribute("cart");
				request.setAttribute("successMessage", "Der Kurs mit der Nummer "+courseID+" wurde erfolgreich aus Ihrem Warenkorb gelöscht");
				request.getSession().setAttribute("cart",cart);
			}
			else if(courseID==null){
			//That the courseID is null shouldn't happen, but if it happen an error message is sent
				request.setAttribute("errorMessage", "Die KursID ist nicht gefüllt, deswegen konnte kein Kurs gelöscht werden");
			}
			else{
			//If the course is already deleted, send an errorMessage 
				request.setAttribute("errorMessage", "Dieser Kurs wurde schon gelöscht bitte aktualisieren sie die Seite.");
			}
		}
		else {
		//If the cart is null, what shouldn't happen, return an errorMessage			
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
