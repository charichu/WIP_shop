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
	
	/**
	*
	* Constructor to hash a string
	*
	* @param stringToHash string that will be hashed
	*/
	public HashedString(String stringToHash){
		int iterations = 1000;
        try {
        	salt = generateSalt();
    	    hashed = generateHash(stringToHash.toCharArray(), iterations);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		    
	}
	
	/**
	*
	* Constructor to hash a string
	*
	* @param stringToHash string that will be hashed
	* @param salt salt that will be used
	*/
	public HashedString(String stringToHash, byte[] salt){
		int iterations = 1000;
        char[] hashChars = stringToHash.toCharArray();
        this.salt = salt;
        try {
         	hashed = generateHash(hashChars, iterations);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}

	
	/**
	* @return HashedString as String
	*/
	public String toString(){
		return hashed;
	}
	
	/**
	* @return only the hashed String
	*/
	public String getHashedStringOnly(){
		String withoutIteration = hashed.substring(hashed.indexOf(":") + 1);
		return withoutIteration.substring(withoutIteration.indexOf(":") + 1);
	}
	
	/**
	* @return salt byte used to hash
	*/
	public byte[] getSaltByte(){
		return salt;
	}
	
	/**
	*
	* Gets the salt of a HashedString as String
	*
	* @return salt used in parameter
	*/
	public static String getSaltFromHashedString(String hashedString){
		String extractedSalt = "";
		int saltStartIndex = hashedString.indexOf(":") + 1;
		if(saltStartIndex > 0 && saltStartIndex < hashedString.length()){
			int saltEndIndex = hashedString.indexOf(":", saltStartIndex);
			if(saltEndIndex >= 0){
				extractedSalt = hashedString.substring(saltStartIndex, saltEndIndex);					
			}
		}
		return extractedSalt;
	}
	
	/**
	*
	* Generates a hash of the string as often as specified
	*
	* @param stringToHash string that will be hashed
	* @param iterations how often the string will be hashed
	* @return generated hash
	*/
	private String generateHash(char[] stringToHash, int iterations) throws NoSuchAlgorithmException, InvalidKeySpecException
    {         
        PBEKeySpec spec = new PBEKeySpec(stringToHash, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }
	
	/**
	* @return generated salt
	*/
    private byte[] generateSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
     
    /**
	*
	* Converts a byte array to his hex values
	*
	* @param byteArray array of bytes to convert to hex
	* @return HashedString as String
	*/
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
    
    /**
	*
	* Converts a String of hex values to a byte array 
	*
	* @param hexString hex values that will be converted
	* @return byte array of converted string
	*/
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
