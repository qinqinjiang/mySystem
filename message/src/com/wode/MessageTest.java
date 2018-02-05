package com.wode;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * ���Զ��ŷ���
 * @author hlrj
 *
 */
public class MessageTest {
	public static void main(String[] args) {
		HttpClient client = new HttpClient();
		//����post����ʵ��
		PostMethod postMethod = new PostMethod("http://utf8.sms.webchinese.cn");
		//ͷ�ļ�������ת��
		postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		//���ݵĲ���
		NameValuePair[] data = {new NameValuePair("Uid","qinqinjiang"),  //����ע���û���
				new NameValuePair("Key","27e7fb7493f8ed899fe9"),   
				new NameValuePair("smsMob","17318914373"),    //�����͵��ֻ���
				new NameValuePair("smsText","��֤��:8888������ó����˾")}; //���͵�����
		postMethod.setRequestBody(data);
		try {
			//ִ��post����ʵ��
			client.executeMethod(postMethod);
			//��ȡ����ͷ
			Header[] headers = postMethod.getResponseHeaders();
			//��ȡ״̬��
			int statusCode = postMethod.getStatusCode();
			System.out.println("statusCode:"+statusCode);
			for (Header header : headers) {
				System.out.println(header.toString());
			}
			String result = new String(postMethod.getResponseBodyAsString().getBytes("utf-8"));
			System.out.println("result:"+result);  //������Ϣ״̬
			//�ͷ�����
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
