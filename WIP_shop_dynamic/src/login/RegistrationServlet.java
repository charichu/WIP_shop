package login;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import functions.DBFunctions;
import functions.Email;
import functions.Functions_Std;
import functions.HashedString;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	//used to check if all preconditions are ok
    	Boolean isOk = true;
    	
    	//get parameters
    	String username = request.getParameter("txtUsername");
    	String password = request.getParameter("txtPassword");
    	
    	String email = request.getParameter("txtEmail");
    	
    	String userType = request.getParameter("chkUserTypeTeacher");
    	userType = userType == "teacher"? "1" : "2";
    	
    	String firstName = request.getParameter("txtFirstName");
    	String lastName = request.getParameter("txtLastName");
    	
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    	Date birthday = new Date();
    	
    	try {
    		birthday = dateFormat.parse(request.getParameter("numDateOfBirth"));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
    	
    	String birthdayString = new SimpleDateFormat("yyyy-MM-dd").format(birthday);
    	
    	String schoolClass = request.getParameter("txtClass");
    	
    	String student = request.getParameter("ddlStudentType");
    	if(Functions_Std.isStringNullOrEmpty(student)){
    		student = "teacher";
    	}
    
    	String address = null; //is filled afterwards
    	
    	String plz = request.getParameter("txtPlz");
    	String city = request.getParameter("txtCity");
    	String street = request.getParameter("txtStreet");
    	String houseNumber = request.getParameter("txtHousenumber");
    	
    	String encryptedPassword = new HashedString(password).toString();
    	
    	String[] input = new String[]{email,username,encryptedPassword,userType,firstName,lastName,birthdayString,schoolClass,student.toString(), address};
    	
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
    		String selectAddress = DBFunctions.CreateSelectQuery("addresses", new String[]{"addressID"}, String.format("plz=%s AND city='%s' AND street='%s' AND housenumber=%s", plz, city, street, houseNumber));
    		String insertAddress = DBFunctions.CreateInsertQuery("addresses", new String[]{"plz", "city", "street", "housenumber"}, new String[]{plz,"'" + city + "'", "'" + street +"'", houseNumber});
			try {
				ResultSet addressToSelect = DBFunctions.Execute(selectAddress);
				if(!addressToSelect.next())
				{
					DBFunctions.Update(insertAddress);
					addressToSelect = DBFunctions.Execute(selectAddress);
					addressToSelect.next();
				}
				input[input.length - 1] = addressToSelect.getString("addressID");
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		String insertUser = DBFunctions.CreateInsertQuery("user", DBFunctions.tableUser_AddUser, input);
        	try {
    			DBFunctions.Update(insertUser);
    			String activationCode = "Accounts sind bisher standardmäßig aktiviert.";
    			String emailText = String.format("Hallo %s %s,\r\ndein Account kann mit dem folgenden Link aktiviert werden: %s\r\nUsername:%s\r\nPassword:%s", firstName, lastName, activationCode, username, password);
    			Email confirmationEmail = new Email(email, "Registrierung von Tutor24 Account", emailText, null);
    			confirmationEmail.send();
    		} catch (Exception e) {
    			e.printStackTrace();
    			System.out.println(e.getMessage());
    		}	
    	}
        response.sendRedirect("/WIP_shop_dynamic/home.jsp");
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

    /**
	*
	* Checks if Email is already in use
	*
	* @param emailName checks for this specific email
	* @return true if email is in use
	*/
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
			e.printStackTrace();
    		System.out.println(e.getMessage());
		}
    	
    	return bRV;
    }
}
