package struts2.com.interceptor;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 自定义拦截器
 * @author 蒋芹芹
 *
 * 2018年2月8日
 */
public class MyInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("拦截action之前");
		
		//action将通过拦截器使用invocation.invoke()调用执行
		String result = invocation.invoke();
		
		System.out.println("拦截action之后");
		return result;
	}
	
}
