package struts2.com.interceptor;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * �Զ���������
 * @author ������
 *
 * 2018��2��8��
 */
public class MyInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����action֮ǰ");
		
		//action��ͨ��������ʹ��invocation.invoke()����ִ��
		String result = invocation.invoke();
		
		System.out.println("����action֮��");
		return result;
	}
	
}
