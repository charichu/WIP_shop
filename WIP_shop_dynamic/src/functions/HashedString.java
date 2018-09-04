package functions;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;

public class HashedString{
	private String hashed = null;
	private byte[] salt = null;
	//private final String pepper = "WIP_SHOP_TUTOR";
	
	public HashedString(String stringToHash){
		int iterations = 1000;
        char[] hashChars = stringToHash.toCharArray();
        try {
        	salt = getSalt();
    	    hashed = generatePasswordHash(hashChars, iterations);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    
	}
	
	public HashedString(String stringToHash, byte[] salt){
		int iterations = 1000;
        char[] hashChars = stringToHash.toCharArray();
        this.salt = salt;
        try {
         	hashed = generatePasswordHash(hashChars, iterations);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public HashedString(String stringToHash, byte[] salt){
//		setSalt(salt);
//		hashed = hashString(stringToHash);
//	}
	
//	public String hashString(String stringToHash){
//		String rvString = null;
//		try{
//			stringToHash = pepper + stringToHash;
//			
//			MessageDigest md = MessageDigest.getInstance("MD5");
//			md.update(salt);
//			byte[] stringBytes = md.digest(stringToHash.getBytes());
//			StringBuilder sb = new StringBuilder();
//			for(int i = 0; i < stringBytes.length; i++){
//				sb.append(Integer.toString((stringBytes[i] & 0xff) + 0x100, 16).substring(1));
//			}
//			rvString = sb.toString();
//		}
//		catch (NoSuchAlgorithmException e){
//			e.printStackTrace();
//		}
//		return rvString;
//	}
//	
//	private byte[] createSalt(){
//		byte[] curSalt =  new byte[16];		
//		try {
//			SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
//			sr.nextBytes(curSalt);
//			
//			setSaltString(curSalt);
//			salt = saltString.getBytes(StandardCharsets.UTF_8);
//		} catch (NoSuchAlgorithmException e) {
//			// SHA1PRNG exists no handling necessary
//			e.printStackTrace();
//		} catch (NoSuchProviderException e) {
//			// SUN exists no handling necessary
//			e.printStackTrace();
//		}
//		
//		return salt;		
//	}
//	
	public String toString(){
		return hashed;
	}
	
	public String getHashedStringOnly(){
		return hashed.substring(hashed.indexOf(":",hashed.indexOf(":") + 1));
	}
	
	public byte[] getSaltByte(){
		return salt;
	}
	
	public static String getSaltFromHashedString(String hashedString){
		String extractedSalt = "";
		int saltStartIndex = hashedString.indexOf(":") + 1;
		if(saltStartIndex >= 0 && saltStartIndex < hashedString.length()){
			extractedSalt = hashedString.substring(saltStartIndex, hashedString.indexOf(":", saltStartIndex));	
		}
		return extractedSalt;
	}
	
	 //_________________________________________________________//
	
	private String generatePasswordHash(char[] password, int iterations) throws NoSuchAlgorithmException, InvalidKeySpecException
    {         
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }
     
    private byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
     
    public String toHex(byte[] byteArray) throws NoSuchAlgorithmException
    {
        BigInteger bInt = new BigInteger(1, byteArray);
        String hexString = bInt.toString(16);
        int paddingLength = (byteArray.length * 2) - hexString.length();
        if(paddingLength > 0){
            return String.format("%0"  + paddingLength + "d", 0) + hexString;
        } else {
            return hexString;
        }
    }
    
    public static byte[] toByteArray(String hexString){
	    int len = hexString.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
	                             + Character.digit(hexString.charAt(i+1), 16));
	    }
	    return data;
    }
}
