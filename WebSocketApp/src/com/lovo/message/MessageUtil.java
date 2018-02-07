package com.lovo.message;

import java.nio.CharBuffer;
import java.util.HashMap;
/**
 * ��Ϣ�����ࣨ����ǰ����Ϣ��
 * @author Administrator
 *
 */
public class MessageUtil {

    public static HashMap<String,String> getMessage(CharBuffer msg) {
        HashMap<String,String> map = new HashMap<String,String>();
        String msgString  = msg.toString();
        String messages[] = msgString.split(",");
        map.put("fromName", messages[0]);
        map.put("toName", messages[1]);
        map.put("content", messages[2]);
        return map;
    }
}