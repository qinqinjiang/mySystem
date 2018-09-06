package com.shiro.shirodemo;

import com.shiro.shirodemo.user.SysPermissing;
import com.shiro.shirodemo.user.SysRole;
import com.shiro.shirodemo.user.UserInfo;
import com.shiro.shirodemo.user.service.UserInfoService;
import com.shiro.shirodemo.util.EncryptPassword;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * @ClassName MyShiroRealm
 * @Author qinqinjiang
 * @Date 2018/9/3 12:01
 * @Description
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private UserInfoService userInfoService;


    /**
     * @param
     * @return
     * @description 授权
     * @author qinqinjiang
     * @date 2018/7/20 16:25
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
        for (SysRole role : userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRole());
            for (SysPermissing p : role.getPermissings()) {
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }


    /**
     * @param
     * @return
     * @description 认证
     * @author qinqinjiang
     * @date 2018/7/20 16:25
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        UserInfo userInfo = userInfoService.findByUserName(username);
        if (null == userInfo) {
            return null;
        }
        // 登录密码加密
        UserInfo user = EncryptPassword.encryptPassword(userInfo);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, user.getPassword(),
                ByteSource.Util.bytes(userInfo.getName()), getName());
        return simpleAuthenticationInfo;
    }
}
