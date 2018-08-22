import java.io.IOException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	private final String username = "noreply.tutor24.de";
	private final String password = "WIP_shop";
	private MimeMessage emailMsg = null;
	
	public Email(String to,String from, String subject, String text) throws MessagingException {
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		
		Session sess = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(username, password);
			}
		});
		
		try{
			MimeMessage constrMsg = new MimeMessage(sess);
			constrMsg.setFrom(new InternetAddress(from));
			constrMsg.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
			constrMsg.setSubject(subject);
			constrMsg.setText(text); //could instead send html code with: constrMsg.setContent(object, type);
			emailMsg = constrMsg;
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Boolean Send() throws MessagingException, IOException {
		Boolean bRV = false; //bRV means bool return value - only used to check if it was successful
		
		try {
			Transport.send(emailMsg);
		} catch (Exception e) {
			bRV = false;
		}
		
		return bRV;
    }
}