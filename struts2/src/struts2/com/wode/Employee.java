package struts2.com.wode;

import com.opensymphony.xwork2.ActionSupport;

/**
 * struts2验证框架demo
 * @author 蒋芹芹
 *
 * 2018年2月8日
 */
public class Employee extends ActionSupport{
	private String name;
	private int age;
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void validate(){
		if (name == null || name.trim().equals("")) {
			addFieldError("name", "The name is required");
		}
		if (age <18 || age >65) {
			addFieldError("age", "age must be in between 18 and 65");
		}
	}
	
}
