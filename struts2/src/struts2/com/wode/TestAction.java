package struts2.com.wode;

import java.util.HashMap;
import java.util.Map;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class TestAction extends ActionSupport{
	private String name;
	
	@Override
	public String execute() throws Exception {
		//获取值栈
		ValueStack stack = ActionContext.getContext().getValueStack();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key1", "这是key1");
		map.put("key2", "这是key2");
		stack.push(map);
		System.out.println("值栈长度:"+stack.size());
		return SUCCESS;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
