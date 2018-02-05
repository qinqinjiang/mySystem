package passwordEncrypt.com.wode;

	/** 
	 * Des���ܽ��ܹ����� 
	 */  
	public class EncryUtil {  
	      
	    /** 
	     * ʹ��Ĭ����Կ����DES���� 
	     */  
	    public static String encrypt(String plainText) {  
	        try {  
	            return new DesUtil().encrypt(plainText);  
	        } catch (Exception e) {  
	            return null;  
	        }  
	    }  
	  
	      
	    /** 
	     * ʹ��ָ����Կ����DES���� 
	     */  
	    public static String encrypt(String plainText, String key) {  
	        try {  
	            return new DesUtil(key).encrypt(plainText);  
	        } catch (Exception e) {  
	            return null;  
	        }  
	    }  
	      
	  
	    /** 
	     * ʹ��Ĭ����Կ����DES���� 
	     */  
	    public static String decrypt(String plainText) {  
	        try {  
	            return new DesUtil().decrypt(plainText);  
	        } catch (Exception e) {  
	            return null;  
	        }  
	    }  
	  
	      
	    /** 
	     * ʹ��ָ����Կ����DES���� 
	     */  
	    public static String decrypt(String plainText, String key) {  
	        try {  
	            return new DesUtil(key).decrypt(plainText);  
	        } catch (Exception e) {  
	            return null;  
	        }  
	    }  
	  
}
