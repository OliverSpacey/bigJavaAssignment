package businessLogicLayer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

//import dataAccessLayer.*;

public class Login {
	
	
	private static char[] passwordCheck;
	
	public static boolean login(String un, char[] pw, ArrayList<User> logins) {
		for (int i = 0; i<logins.size(); i++) {
			if (logins.get(i).username.equals(un)) {
				passwordCheck = logins.get(i).password.toCharArray();
				if(isPassword(pw)) {
					return true;
				}
			}
		} 
		return false;
	}

	
	public static boolean isPassword(char[] password) {
		boolean result = false;
		byte[] pass_in = encode(password);
		byte[] pass_user = encode(passwordCheck);
		
		if(Arrays.equals(pass_in, pass_user)) {
			result = true;
		}
		
		Arrays.fill(pass_in, (byte)0);
		Arrays.fill(pass_user, (byte)0);
		
		return result;
	}
	
	private static ByteBuffer charsAsByteBuffer(char[] chars) {
		CharBuffer cb = CharBuffer.wrap(chars);
		Charset utfCharset = Charset.forName("UTF-8");
		ByteBuffer bb = utfCharset.encode(cb);
		
		return bb;
	}
	
	private static byte[] encode(char[] chars) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");
			md.update(charsAsByteBuffer(chars));
			return md.digest();
		}
		catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
			return charsAsByteBuffer(chars).array();
		}
	}
	
}
