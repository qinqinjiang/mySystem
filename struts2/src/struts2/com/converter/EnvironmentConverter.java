package struts2.com.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
/**
 * Environment
 * @author ½¯ÇÛÇÛ
 *
 * 2018Äê2ÔÂ9ÈÕ
 */
public class EnvironmentConverter extends StrutsTypeConverter{
	@Override
	public Object convertFromString(Map context, String[] values, Class clazz) {
		// TODO Auto-generated method stub
		Environment environment = new Environment(values[0]);
		return environment;
	}
	@Override
	public String convertToString(Map context, Object value) {
		// TODO Auto-generated method stub
		Environment environment = (Environment) value;
		return environment == null ? null:environment.getName();
	}
}
