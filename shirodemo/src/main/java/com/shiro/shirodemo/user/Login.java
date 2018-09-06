package com.shiro.shirodemo.user;

import com.shiro.shirodemo.util.EncryptPassword;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName Login
 * @Author qinqinjiang
 * @Date 2018/9/3 14:03
 * @Description
 */
@RestController
public class Login {

    private static final Logger log = LoggerFactory.getLogger(Login.class);

    @RequestMapping("/login")
    public String login() {
        Subject user = SecurityUtils.getSubject();
        log.info(user.getPrincipal() + "登录");
        if (!user.isAuthenticated()) {
            try {
                UserInfo userInfo = new UserInfo();
                userInfo.setName("aa");
                userInfo.setPassword("123");
                UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getName(), userInfo.getPassword());
                //token.setRememberMe(true);
                user.login(token);
            } catch (UnknownAccountException unknownAccountException) {
                log.info("用户不存在");
            } catch (IncorrectCredentialsException incorrectCredentialsException) {
                log.info("密码错误");
            } catch (LockedAccountException lockedAccountException) {
                log.info("账号被锁");
            } catch (AuthenticationException e) {
                log.info("登录失败：{}", e);
            }
        }
        //user.logout();
        log.info("登录成功");
        return "/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "/index";
    }
}
