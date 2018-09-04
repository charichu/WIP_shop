package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("user");
		String pass  = request.getParameter("pass");
		String name  = "";
		String tempPass = "";
		Integer userId;
		int userType;
		Boolean userLoggedIn;
		try {
//			create database connection
		            Class.forName("com.mysql.jdbc.Driver").newInstance();
		            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wip", "root", "");
		            Statement statement = myConn.createStatement();
//		    make sql statement
		            ResultSet rs = statement.executeQuery("select * from user where email='"+email+"';");
		            
		            if( !rs.last()){
//		    if the result of the SQL-statement is empty, so there exists no account:
//		    go to homepage with error message        
		            	request.setAttribute("loginResultMessage", "Login ist fehlgeschlagen, es existiert kein User Accout zu dieser Adresse.");
		            	userLoggedIn = false;
		            	request.getSession().setAttribute("userLoggedIn", userLoggedIn);
		            	request.getRequestDispatcher("home.jsp").forward(request, response);
		            	return;
		            }
		            else if (rs.getRow()>1) {
//		    if there are multiple accounts on one Mail go to the homepage with error message
		            	request.setAttribute("loginResultMessage", "Login ist fehlgeschlagen, es sind mehrere Accounts mit dieser E-Mail vorhanden.");
		            	userLoggedIn = false;
		            	request.getSession().setAttribute("userLoggedIn", userLoggedIn);
		            	request.getRequestDispatcher("home.jsp").forward(request, response);
		            	return;
		            }
		            else{
//		    here one and only one account exists to the given e-mail
			            do{
							tempPass = rs.getString("password");
							userType = rs.getInt("userType");
							name     = rs.getString("username");
							userId   = rs.getInt("userID");
	 					}
			            while (rs.next());
//			password control
			            if(pass.equals(tempPass) ){
//				password right, set the session variables to be logged in
			            	userLoggedIn = true;
			            	request.getSession().setAttribute("userLoggedIn", userLoggedIn);
			            	request.getSession().setAttribute("userType", userType);
			            	request.getSession().setAttribute("userName", name);
			            	request.getSession().setAttribute("userId", userId);
			            	if(userType == 0){
//					if user is admin go to adminpage
				            	request.getRequestDispatcher("admin.jsp").forward(request, response);
				            }
				            else {
//		    		if user is teacher or a normal user go to homepage
				            	request.getRequestDispatcher("home.jsp").forward(request, response);
							}
			            }
//			    password wrong, go to homepage with an error message
			            else {
			            	
			            	request.setAttribute("loginResultMessage", "Login ist fehlgeschlagen, falsches Passwort");
			            	userLoggedIn = false;
			            	request.getSession().setAttribute("userLoggedIn", userLoggedIn);
			            	request.getRequestDispatcher("home.jsp").forward(request, response);
						}
		            }
		}
		// exception handling
        catch (Exception e) {
            System.out.println("error"+e.getMessage());
            System.out.println(e.getStackTrace());
            
        }
 		doGet(request, response);
	}

}
