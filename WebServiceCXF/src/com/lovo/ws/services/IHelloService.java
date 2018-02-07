package com.lovo.ws.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace="http://ws.lovo.com/",serviceName="HelloService",portName="HelloServicePort")
public interface IHelloService {
	
	@WebResult(name = "helloResult",targetNamespace="http://ws.lovo.com/") 
	@WebMethod(operationName="sayHello")
	public String hello(@WebParam(name="msg")String msg);
	
	
	
	@WebResult(name = "loginResult",targetNamespace="http://ws.lovo.com/") 
	@WebMethod(operationName="sayLogin")
	public String login(@WebParam(name="userName")String userName,@WebParam(name="password")String password);
}
