package com.lovo.ws.client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;



public class Test {

	private static final QName SERVICE_NAME = new QName("http://ws.lovo.com/",
			"HelloService");
	private static final QName PORT_NAME = new QName("http://ws.lovo.com/",
			"HelloServicePort");

	public static void main(String[] args) {
		testHello();
		testLogin();
	}

	private static void testLogin() {
		// TODO Auto-generated method stub
		try {
			Service service = Service.create(SERVICE_NAME);
			String endpointAddress = "http://localhost:8080/WebServiceCXF/services/HelloService";
			service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING,
					endpointAddress);

			IHelloService hw = service.getPort(IHelloService.class);
			
			System.out.println(hw.login("lovo","123456"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testHello() {
		// TODO Auto-generated method stub
		try {
			Service service = Service.create(SERVICE_NAME);
			String endpointAddress = "http://localhost:8080/WebServiceCXF/services/HelloService";
			service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING,
					endpointAddress);

			IHelloService hw = service.getPort(IHelloService.class);
			System.out.println(hw.hello("中国"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
