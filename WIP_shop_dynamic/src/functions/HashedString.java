package functions;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.nio.charset.StandardCharsets;

public class HashedString{
	private String hashed = null;
	private byte[] salt = null;
	private String saltString = null;
	private final String pepper = "WIP_SHOP_TUTOR";
	
	public HashedString(String stringToHash){
		salt = createSalt();
		hashed = hashString(stringToHash);
	}
	
	public HashedString(String stringToHash, byte[] salt){
		this.salt = salt;
		setSaltString(salt);
		hashed = hashString(stringToHash);
	}
	
	public String hashString(String stringToHash){
		String rvString = null;
		try{
			stringToHash = pepper + " " + stringToHash;
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(salt);
			byte[] stringBytes = md.digest(stringToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < stringBytes.length; i++){
				sb.append(Integer.toString((stringBytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			rvString = sb.toString();
		}
		catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return rvString;
	}
	
	private byte[] createSalt(){
		byte[] curSalt =  new byte[16];		
		try {
			SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
			sr.nextBytes(curSalt);
			
			setSaltString(curSalt);
			salt = saltString.getBytes(StandardCharsets.UTF_8);
		} catch (NoSuchAlgorithmException e) {
			// SHA1PRNG exists no handling necessary
			e.printStackTrace();
		}
		
		return salt;		
	}
	
	public String toString(){
		return hashed + " " + getSalt();
	}
	
	public String getHashedStringOnly(){
		return hashed;
	}
	
	public String getSalt(){
		return saltString;
	}
	
	private void setSaltString(byte[] curSalt){ 
		if(salt != null){
			curSalt = salt;
		}
		saltString = new String(curSalt, StandardCharsets.UTF_8);
	}
	
	public byte[] getSaltByte(){
		return salt;
	}
	
	public static String getSaltFromHashedString(String hashedString){
		String extractedSalt = "";
		int whiteSpaceIndex = hashedString.indexOf(" ");
		if(whiteSpaceIndex >= 0 && whiteSpaceIndex < hashedString.length()){
			extractedSalt = hashedString.substring(whiteSpaceIndex) + 1;	
		}
		return extractedSalt;
	}
	
	public static byte[] getSaltByteFromHashedString(String hashedString){
		return getSaltFromHashedString(hashedString).getBytes(StandardCharsets.UTF_8);
	}
}
