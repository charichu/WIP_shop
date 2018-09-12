package profile;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import functions.User;
/**
 * Servlet implementation class GetProfile
 */
@WebServlet("/GetProfile")
public class GetProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer userID = request.getSession().getAttribute("userId")!=null?(Integer)request.getSession().getAttribute("userId"):null;
		boolean userLoggedIn = request.getSession().getAttribute("userLoggedIn")!=null?(boolean)request.getSession().getAttribute("userLoggedIn"):false;
		
		if(userID!=null&&userLoggedIn){
			User currentUser = new User(userID);
			request.setAttribute("currentUser", currentUser);
			request.getRequestDispatcher("Profil.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMessage", "Sie sind nicht eingeloggt und können deshalb Ihr Profil nicht bearbeiten.");
			request.getRequestDispatcher("home.jsp").forward(request, response);
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
