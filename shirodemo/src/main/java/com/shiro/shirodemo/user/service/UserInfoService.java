package com.shiro.shirodemo.user.service;

import com.shiro.shirodemo.user.UserInfo;
import com.shiro.shirodemo.user.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserInfoService
 * @Author qinqinjiang
 * @Date 2018/9/3 14:32
 * @Description
 */
@Service
public class UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;

    public UserInfo findByUserName(String userName) {
        UserInfo userInfo = userInfoDao.findByUsername(userName);
        return userInfo;
    }

    public List<UserInfo> listUserInfo(){
        List<UserInfo> userInfos = userInfoDao.findAll();
        return userInfos;
    }
}
