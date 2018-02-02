package passwordEncrypt.com.wode;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 * @author hlrj
 *
 */
public class MD5Util {
	/**
	 * MD5加密  生成32位MD5码
	 * @param password 待加密密码
	 * @return  32位MD5码
	 * @throws UnsupportedEncodingException 
	 */
	public static String Md5Encode(String password) throws UnsupportedEncodingException{
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] arr = password.getBytes("UTF-8");
		byte[] md5Bytes = md5.digest(arr);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = md5Bytes[i] & 0xff;
			if (val <16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
	
	public static void main(String[] args) {
		try {
			String password = MD5Util.Md5Encode("123");
			System.out.println(password);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
