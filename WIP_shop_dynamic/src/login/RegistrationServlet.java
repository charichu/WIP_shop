package login;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import functions.DBFunctions;
import functions.Email;
import functions.HashedString;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//used to check if all preconditions are ok
    	Boolean isOk = true;
    	
    	//get parameters
    	String email = request.getParameter("txtEmail");
    	String username = request.getParameter("txtUsername");
    	String password = request.getParameter("txtPassword");
    	Boolean teacher = Boolean.parseBoolean(request.getParameter("chkTeacher"));
    	String firstName = request.getParameter("txtFirstName");
    	String lastName = request.getParameter("txtLastName");
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    	Date birthday = new Date();
    	try {
    		birthday = dateFormat.parse(request.getParameter("txtBirthday"));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
    	
    	String birthdayString = new SimpleDateFormat("yyyy-MM-dd").format(birthday);
    	
    	String schoolClass = request.getParameter("txtClass");
    	Boolean student = Boolean.parseBoolean(request.getParameter("chkStudent"));
    	String address = "1";//request.getParameter("txtEmail");
    	String qualificationProfile = "";
    
    	String encryptedPassword = new HashedString(password).toString();
    	
    	String[] input = new String[]{email,username,encryptedPassword,teacher.toString(),firstName,lastName,birthdayString,schoolClass,student.toString(), qualificationProfile, address};
    	
    	// check preconditions
    	isOk &= !isEmailInUse(email);
    	for(int i = 0; i < input.length; i++) {
    		if (input[i] != null) {
    			isOk &= DBFunctions.ContainsOnlyAllowedChars(input[i]);
    			if(input[i] != "false" && input[i] != "true")
    				input[i] = String.format("'%s'", input[i]);
    			if(i == 6){
    				input[i] = "STR_TO_DATE(" + input[i] + ", '%Y-%m-%d')";
    			}
			}
		}
    	//isOk &= Email.IsValid(email);
    	
    	// use parameters
    	if(isOk){
    		//test
    		String insertQuery = DBFunctions.CreateInsertQuery("user", DBFunctions.tableUserManipulation, input) + "";
        	try {
    			DBFunctions.Update(insertQuery);
    			String activationCode = "Accounts sind bisher standardmäßig aktiviert.";
    			String emailText = String.format("Hallo %s %s,\r\ndein Account kann mit dem folgenden Link aktiviert werden: %s\r\nUsername:%s\r\nPassword:%s", firstName, lastName, activationCode, username, password);
    			Email confirmationEmail = new Email(email, "Registrierung von Tutor24 Account", emailText);
    			confirmationEmail.Send();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			System.out.println(e.getMessage());
    		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
    			System.out.println(e.getMessage());
    		}	
    	}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

    private Boolean isEmailInUse(String emailName){
    	Boolean bRV = false;
    	
    	try {
			String emailQuery = DBFunctions.CreateSelectQuery("user", new String[]{"COUNT(email) emailExists"}, "email = '" + emailName + "'");
			ResultSet EmailsWithName = DBFunctions.Execute(emailQuery);
			try {
				EmailsWithName.next();
				if(EmailsWithName.getInt("emailExists") > 0){
					bRV = true;
				} 	
			} catch (Exception e) {
				// email does not exist
			}
    	} catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
    		System.out.println(e.getMessage());
		}
    	
    	return bRV;
    }
    
    public String NVL(Object item1, Object item2){
    	if(item1 != null){
    		return item1.toString();
    	} else {
    		return item2.toString();
    	}
    }
}
