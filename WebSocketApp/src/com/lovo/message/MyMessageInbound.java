package com.lovo.message;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.HashMap;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;

import com.lovo.servlet.InitServlet;


public class MyMessageInbound extends MessageInbound {

    private String name;
    public MyMessageInbound() {
        super();
    }

    public MyMessageInbound(String name) {
        super();
        this.name = name;
    }

    @Override  
    protected void onBinaryMessage(ByteBuffer arg0) throws IOException {  
        // TODO Auto-generated method stub 
          
    }  
  
    @Override  
    protected void onTextMessage(CharBuffer msg) throws IOException { 
        //用户所发消息处理后的map
        HashMap<String,String> messageMap = MessageUtil.getMessage(msg);    //处理消息类
        //上线用户集合类map
        HashMap<String, MessageInbound> userMsgMap = InitServlet.getSocketList();
        
        String fromName = messageMap.get("fromName");    //消息来自人 的userId
        
  
        String toName = messageMap.get("toName");         //消息发往人的 userId
        //获取该用户
        MessageInbound messageInbound = userMsgMap.get(toName);    //在仓库中取出发往人的MessageInbound
        
        
        
        if(messageInbound!=null){     //如果发往人 存在进行操作
             WsOutbound outbound = messageInbound.getWsOutbound(); 
             
             
             String content = messageMap.get("content");  //获取消息内容
             String msgContentString = fromName + "     " + content;   //构造发送的消息
             
             //发出去内容
             CharBuffer toMsg =  CharBuffer.wrap(msgContentString.toCharArray());
            outbound.writeTextMessage(toMsg);  //
            outbound.flush();
        }
     
        
        
      /*  for (MessageInbound messageInbound : InitServlet.getSocketList()) {  
            CharBuffer buffer = CharBuffer.wrap(msg);  
            WsOutbound outbound = messageInbound.getWsOutbound();  
            outbound.writeTextMessage(buffer);  
            outbound.flush();  
        }  */
          
    }  
  
    @Override  
    protected void onClose(int status) {  
        InitServlet.getSocketList().remove(this);  
        super.onClose(status);  
    }  
  
    @Override  
    protected void onOpen(WsOutbound outbound) {  
        super.onOpen(outbound);  
        //登录的用户注册进去
        if(name!=null){
            InitServlet.getSocketList().put(name, this);  
        }
//        InitServlet.getSocketList().add(this);  
    }  
      
      
}
