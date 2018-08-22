import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class HashedString{
	private String hashed = null;
	private byte[] salt = null;
	
	public HashedString(String stringToHash){
		hashed = HashString(stringToHash);
	}
	
	public String ToString(){
		return hashed + salt;
	}
	
	public String GetHashedString(){
		return hashed;
	}
	
	public byte[] GetSalt(){
		return salt;
	}
	
	public String HashString(String stringToHash){
		String rvString = null;
		try{
			if(salt == null){
				salt = CreateSalt();
			}
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
	
	private static byte[] CreateSalt() throws NoSuchAlgorithmException{
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt =  new byte[16];
		sr.nextBytes(salt);
		System.out.println(salt.toString());
		return salt;		
	}
}
