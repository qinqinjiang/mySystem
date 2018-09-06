package com.shiro.shirodemo.util;

import com.shiro.shirodemo.user.UserInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @ClassName EncryptPassword
 * @Author qinqinjiang
 * @Date 2018/9/5 10:54
 * @Description
 */
public class EncryptPassword {
    private final static String algorithmName = "md5";
    private final static int hashIterations = 2;
    
    
     /**
       * @description 密码加密
       * @param
       * @author qinqinjiang
       * @date 2018/7/20 16:25
       * @return 
       */
    public static UserInfo encryptPassword(UserInfo user) {
        String newPassword = new SimpleHash(algorithmName, user.getPassword(),  ByteSource.Util.bytes(user.getName()), hashIterations).toHex();
        user.setPassword(newPassword);
        return user;
    }
}
