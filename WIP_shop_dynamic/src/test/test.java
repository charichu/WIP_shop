package test;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

import functions.Email;
import functions.HashedString;

public class test {

	public static void main(String[] args) {
		try {
//			String password = "test";
//			String salt = "";
//			byte[] saltByte = salt.getBytes(StandardCharsets.UTF_8);
//			
//			HashedString hString = new HashedString(password);
//			
//			String extractedSalt = HashedString.getSaltFromHashedString(hString.toString());
//			System.out.println("Hashed: " + hString.toString() + "\r\nExtracted Salt:" + extractedSalt);
			Email email = new Email("thomas@x-arts.net", "test", "port 25", null);
			email.send();
//			
//			hString = new HashedString("testPassword", saltByte);
//			
//			System.out.println("Hashed: " + hString.toString());
//			
//			hString = new HashedString("testPassword", saltByte);
//			
//			System.out.println("Hashed: " + hString.toString());
//			//hString = new HashedString("testPassword", )
//			
			
			//System.out.println(HashedString.CreateSalt().toString().substring(3).length());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
