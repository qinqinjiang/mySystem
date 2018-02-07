package com.lovo.ws.services;

import javax.jws.WebService;

@WebService(endpointInterface="com.lovo.ws.services.IHelloService")
public class HelloServiceImpl implements IHelloService {
	
	public String hello(String msg) {
		// TODO Auto-generated method stub
		return "你好！" + msg;
	}

	
	public String login(String userName,String password){
		
		return userName +" "+password;
	}
	
}
