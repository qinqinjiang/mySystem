package com.wode;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 测试短信发送
 * @author hlrj
 *
 */
public class MessageTest {
	public static void main(String[] args) {
		HttpClient client = new HttpClient();
		//创建post方法实例
		PostMethod postMethod = new PostMethod("http://utf8.sms.webchinese.cn");
		//头文件中设置转码
		postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		//传递的参数
		NameValuePair[] data = {new NameValuePair("Uid","qinqinjiang"),  //网建注册用户名
				new NameValuePair("Key","27e7fb7493f8ed899fe9"),   
				new NameValuePair("smsMob","17318914373"),    //将发送的手机号
				new NameValuePair("smsText","验证码:8888芹天商贸部公司")}; //发送的内容
		postMethod.setRequestBody(data);
		try {
			//执行post方法实例
			client.executeMethod(postMethod);
			//获取返回头
			Header[] headers = postMethod.getResponseHeaders();
			//获取状态码
			int statusCode = postMethod.getStatusCode();
			System.out.println("statusCode:"+statusCode);
			for (Header header : headers) {
				System.out.println(header.toString());
			}
			String result = new String(postMethod.getResponseBodyAsString().getBytes("utf-8"));
			System.out.println("result:"+result);  //返回消息状态
			//释放连接
			postMethod.releaseConnection();
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
