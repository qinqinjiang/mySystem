package passwordEncrypt.com.wode;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * SHA密码加密工具类
 * @author hlrj
 *
 */
public class PasswordSHAUtil {
	
	/**
	 * 生成40位SHA码
	 * @param password 
	 * @return 返回40位SHA码
	 * @throws Exception 
	 */
	public static String createDigest(String password) throws Exception{
			MessageDigest sha = null;
			try {
				sha = MessageDigest.getInstance("SHA");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] byteArray = password.getBytes("UTF-8");
			byte[] digest = sha.digest(byteArray);
			StringBuffer hexBuffer = new StringBuffer();
			for (int i = 0; i < digest.length; i++) {
				int value = digest[i] & 0xff;
				if (value < 16) {
					hexBuffer.append("0");
				}
				hexBuffer.append(Integer.toHexString(value));
			}
			return hexBuffer.toString();
			
	}
	
	public static void main(String[] args) {
		String password;
		try {
			password = PasswordSHAUtil.createDigest("123");
			System.out.println(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
