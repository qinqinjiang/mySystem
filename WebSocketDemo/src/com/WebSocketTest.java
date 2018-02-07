package com;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * webSocket测试demo
 * @author jiangqinqin
 *
 */
@ServerEndpoint("/webSocket")
public class WebSocketTest {
	//记录在线人数
	private static int onclineCount = 0;
	//线程安全的set，存放每个客户端对应的WebSocket对象，如果服务器端与单一用户通讯，可以使用map存放
	private static CopyOnWriteArraySet<WebSocketTest> webSocketSet = new CopyOnWriteArraySet<WebSocketTest>();
	//与客户端的会话，用来给客户端发送数据
	private Session session;
	
	/**
	 * 连接建立成功调用的方法
	 * @param session
	 * jiangqinqin
	 */
	@OnOpen
	public void onopen(Session session){
		this.session = session;
		webSocketSet.add(this);
		//在线人数加1
		countAdd();  
		System.out.println("有新用户连接！当前用户人数为："+getCount());
	}
	
	/**
	 * 连接关闭调用的方法
	 * jiangqinqin
	 */
	@OnClose
	public void onclose(){
		webSocketSet.remove(this);
		//在线人数减1
		countSub();
		System.out.println("有连接关闭，当前人数为："+getCount());
	}
	
	/**
	 * 收到客户端消息时调用的方法
	 * @param message
	 * @param session
	 * jiangqinqin
	 */
	@OnMessage
	public void onMessage(String message,Session session){
		System.out.println("来自客户端的消息："+message);
		//群发消息
		for (WebSocketTest webSocketTest : webSocketSet) {
			try {
				webSocketTest.sendMessage(message);
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
		}
	}
	
	/**
	 * 连接发生错误
	 * @param error
	 * jiangqinqin
	 */
	public void onError(Throwable error){
		System.out.println("连接发生错误");
		error.printStackTrace();
	}
	
	/**
	 * 发送消息
	 * jiangqinqin
	 * @throws IOException 
	 */
	public void sendMessage(String message) throws IOException{
		this.session.getBasicRemote().sendText(message);
	}
	
	/**
	 * 人数增加
	 * 
	 * jiangqinqin
	 */
	public synchronized int countAdd(){
		return WebSocketTest.onclineCount++;
	}
	
	/**
	 * 人数减少
	 * @return
	 * jiangqinqin
	 */
	public synchronized int countSub(){
		return WebSocketTest.onclineCount--;
	}
	
	/**
	 * 获取当前人数
	 * @return
	 * jiangqinqin
	 */
	public synchronized int getCount(){
		return WebSocketTest.onclineCount;
	}
}
