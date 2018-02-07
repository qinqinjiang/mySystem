package com.lovo.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;

public class StringToDateConverter implements Converter<String, Date>{
	@Override
	public Date convert(String source) {
		Date date = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
			date = format.parse(source);  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	//测试自定义类型转换器
	public static void main(String[] args) {
		//创建类型转换服务实例
		GenericConversionService conversionService = new GenericConversionService();
		//向类型转换服务实例中注册自定义类型转换器
		conversionService.addConverter(new StringToDateConverter());
		//使用类型转换服务完成类型转换
		String dateStr = "2012-5-13";
		Date date = conversionService.convert(dateStr,Date.class);
		System.out.println(date);
	}
}


