package com.lovo.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;

public class DateToStringConverter implements Converter<Date, String> {
	public String convert(Date date) {
		String dateStr = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			dateStr = format.format(date);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateStr;
	};

	// 测试自定义类型转换器
	public static void main(String[] args) {
		// 创建类型转换服务实例
		GenericConversionService conversionService = new GenericConversionService();
		// 向类型转换服务实例中注册自定义类型转换器
		conversionService.addConverter(new DateToStringConverter());
		// 使用类型转换服务完成类型转换
		String dateStr = conversionService.convert(new Date(), String.class);
		System.out.println(dateStr);
	}
}
