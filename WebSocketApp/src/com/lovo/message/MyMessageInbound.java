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
        //�û�������Ϣ������map
        HashMap<String,String> messageMap = MessageUtil.getMessage(msg);    //������Ϣ��
        //�����û�������map
        HashMap<String, MessageInbound> userMsgMap = InitServlet.getSocketList();
        
        String fromName = messageMap.get("fromName");    //��Ϣ������ ��userId
        
  
        String toName = messageMap.get("toName");         //��Ϣ�����˵� userId
        //��ȡ���û�
        MessageInbound messageInbound = userMsgMap.get(toName);    //�ڲֿ���ȡ�������˵�MessageInbound
        
        
        
        if(messageInbound!=null){     //��������� ���ڽ��в���
             WsOutbound outbound = messageInbound.getWsOutbound(); 
             
             
             String content = messageMap.get("content");  //��ȡ��Ϣ����
             String msgContentString = fromName + "     " + content;   //���췢�͵���Ϣ
             
             //����ȥ����
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
        //��¼���û�ע���ȥ
        if(name!=null){
            InitServlet.getSocketList().put(name, this);  
        }
//        InitServlet.getSocketList().add(this);  
    }  
      
      
}
