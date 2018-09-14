package functions;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {
	private final String username = "noreply.tutor24@gmail.com";
	private final String password = "WIP_shop";
	private MimeMessage emailMsg = null;
	private String recipient = null;
	
	public Email(String to, String subject, String text, String attachmentLocation) {
		
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
			MimeMessage mailMsg = new MimeMessage(sess);
			mailMsg.setHeader("Content-Type", "text/plain; charset=UTF-8");
			MimeBodyPart mailBody = new MimeBodyPart();
			MimeMultipart mailMulti = new MimeMultipart();
			mailMsg.setFrom(new InternetAddress(username));
			mailMsg.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
			mailMsg.setSubject(subject);
			mailBody.setText(text); //could instead send html code with: constrMsg.setContent(object, type);
			mailMulti.addBodyPart(mailBody);

			if(!Functions_Std.isStringNullOrEmpty(attachmentLocation)){
				DataSource dSource = new FileDataSource(attachmentLocation);
				mailBody = new MimeBodyPart();
				mailBody.setDataHandler(new DataHandler(dSource));
				mailBody.setFileName(attachmentLocation);
				mailMulti.addBodyPart(mailBody);
			}
			mailMsg.setContent(mailMulti);
			emailMsg = mailMsg;
			recipient = to;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Boolean send() throws IOException {
		Boolean bRV = true; //bRV stands for bool return value - only used to check if it was successful
		
		try {
			Transport.send(emailMsg);
			System.out.println("Email verschickt an: " + recipient);
		} catch (Exception e) {
			bRV = false;
			e.printStackTrace();
		}
		
		return bRV;
    }
	
	public static Boolean IsValid(String EmailName){
		Boolean bRV = true;
		try {
			InternetAddress EmailAddress = new InternetAddress(EmailName);
			EmailAddress.validate();
		} catch (AddressException e) {
			bRV = false;
		}
		return bRV;
	}
}
