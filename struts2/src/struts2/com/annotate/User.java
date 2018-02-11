package struts2.com.annotate;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
/**
 * 注解测试
 * @author 蒋芹芹
 *
 * 2018年2月9日
 */
@Results({
	@Result(name="success",location="/result.jsp"),
	@Result(name="input",location="/invalidate.jsp")
})
public class User extends ActionSupport{
	private String userName;
	private int age;
	
	@Action(value="/user")
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	@RequiredFieldValidator(message="the name is required")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@IntRangeFieldValidator(message="the age must be in between 18 and 65",min="18",max="65")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
