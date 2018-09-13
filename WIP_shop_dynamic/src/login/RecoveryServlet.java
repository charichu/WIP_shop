package login; 

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import functions.DBFunctions;
import functions.Email;
import functions.Functions_Std;
import functions.HashedString;

@WebServlet("/RecoveryServlet")
public class RecoveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RecoveryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = null;
		String userID = null;
		String activationCode = null;
		try {
			url = request.getParameter("recoveryTarget").substring(request.getParameter("recoveryTarget").indexOf("?") + 1);
			userID = url.substring(url.indexOf("id=") + 3, url.indexOf("&code="));
			activationCode = url.substring(url.indexOf("&code=") + 6);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(userID != null && activationCode != null){
			String newPassword = request.getParameter("txtNewPassword");
			if(!Functions_Std.isStringNullOrEmpty(newPassword)){
				try {
					ResultSet emailSelect = DBFunctions.Execute(DBFunctions.CreateSelectQuery("user", new String[]{"email", "password"}, "userID = " + userID));
					if(emailSelect.next()){
						String password = emailSelect.getString("password");
						String email = emailSelect.getString("email");
						String salt = HashedString.getSaltFromHashedString(password);
						HashedString dbActivationCode = new HashedString(email + password, HashedString.toByteArray(salt));
						if(dbActivationCode.getHashedStringOnly().equals(activationCode)){
							HashedString newHashedPassword = new HashedString(newPassword);
							DBFunctions.Update(DBFunctions.CreateUpdateQuery("user", new String[]{"password"}, new String[]{"'" + newHashedPassword.toString() + "'"}, "user.userID = " + userID));
							Email passwordChanged = new Email(email, "Passwort wurde geändert", "Das Password wurde ändert. Herzlichen Glückwunsch", null);
							passwordChanged.send();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			String email = request.getParameter("txtEmail");
			String password = null;
			String headerName = null;
			if(!Functions_Std.isStringNullOrEmpty(email)){
				try {
					ResultSet emailData = DBFunctions.Execute(DBFunctions.CreateSelectQuery("user", new String[]{"password", "firstName", "lastName", "userID"}, "email = '" + email + "'"));
					if(emailData.next()){
						password = emailData.getString("password");
						headerName = emailData.getString("firstName") + " " + emailData.getString("lastName");
						userID = emailData.getString("userID");
						
					}
					if(!Functions_Std.isStringNullOrEmpty(password)){
						String salt = HashedString.getSaltFromHashedString(password);
						HashedString hashedCode = new HashedString(email + password, HashedString.toByteArray(salt));
						String link = String.format("%s://%s:%s/WIP_shop_dynamic/recovery.jsp?id=%s&code=%s", request.getScheme(), request.getServerName(), request.getServerPort(), userID, hashedCode.getHashedStringOnly());
						String emailBody = String.format("Hallo %s,\r\n öffnen Sie den Link um Ihren Account zu aktivieren.\r\n%s", headerName, link);
						Email recoveryEmail = new Email(email, "Wiederherstellung des Passworts", emailBody, null);
						recoveryEmail.send();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}
        request.getRequestDispatcher("/recovery.jsp").forward(request, response);	          
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
