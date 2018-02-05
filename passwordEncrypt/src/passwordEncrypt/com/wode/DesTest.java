package passwordEncrypt.com.wode;
/**
 * Des加密解密测试
 * @author hlrj
 *
 */
public class DesTest {
	public static void main(String[] args) {
		String str = "12345611";
		String t = EncryUtil.encrypt(str);
		System.out.println("加密后："+t);
		System.out.println("解密后："+EncryUtil.decrypt(t));
	}
}
