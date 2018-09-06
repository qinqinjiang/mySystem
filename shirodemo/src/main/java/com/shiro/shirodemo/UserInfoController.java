package com.shiro.shirodemo;

import com.shiro.shirodemo.user.UserInfo;
import com.shiro.shirodemo.user.service.UserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserInfoController
 * @Author qinqinjiang
 * @Date 2018/9/3 14:57
 * @Description
 */
@RestController
@RequestMapping("/userInfo/")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @RequiresPermissions("userInfo:view")
    @RequestMapping("userInfoList")
    public List<UserInfo> userInfoList(){
        List<UserInfo> userInfos = userInfoService.listUserInfo();
        System.out.println(userInfos);
        return userInfos;
    }

    @RequiresPermissions("userInfo:del")
    @RequestMapping("userInfoDel")
    public String userInfoDel(){
        System.out.println("userDel");
        return "userDel";
    }

    @RequiresPermissions("userInfo:add")
    @RequestMapping("userInfoAdd")
    public String userInfoAdd(){
        System.out.println("userAdd");
        return "userAdd";
    }
}
