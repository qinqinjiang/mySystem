package struts2.com.converter;

import com.opensymphony.xwork2.ActionSupport;

public class SystemDetail extends ActionSupport{
	Environment environment = new Environment("Development");
	private String operatingSystem = "Windows7";
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
}
