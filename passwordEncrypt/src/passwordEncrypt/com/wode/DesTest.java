package passwordEncrypt.com.wode;
/**
 * Des���ܽ��ܲ���
 * @author hlrj
 *
 */
public class DesTest {
	public static void main(String[] args) {
		String str = "12345611";
		String t = EncryUtil.encrypt(str);
		System.out.println("���ܺ�"+t);
		System.out.println("���ܺ�"+EncryUtil.decrypt(t));
	}
}
