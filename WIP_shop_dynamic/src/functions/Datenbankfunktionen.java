package functions;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class Datenbankfunktionen
 */
@WebServlet("/Datenbankfunktionen")
public class Datenbankfunktionen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = "";
	private String user = "root";
	private String password = "";
    /**
     * Default constructor. 
     */
    public Datenbankfunktionen() {
    	try{
    		Class.forName("con.mysql.jdbc.driver").newInstance();
    		Connection con = DriverManager.getConnection(url,user,password);
    		
    		Statement stt = con.createStatement();
    		stt.execute("INSERT INTO adresse(street,plz,houseNumber,city)VALUES (test, test, test, test); ");
    	}
    	catch( Exception e){
    		
    	}
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
