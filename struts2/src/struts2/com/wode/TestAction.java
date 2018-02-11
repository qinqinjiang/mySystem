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
		//��ȡֵջ
		ValueStack stack = ActionContext.getContext().getValueStack();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key1", "����key1");
		map.put("key2", "����key2");
		stack.push(map);
		System.out.println("ֵջ����:"+stack.size());
		return SUCCESS;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
