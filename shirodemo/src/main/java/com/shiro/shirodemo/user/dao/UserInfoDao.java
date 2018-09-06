package com.shiro.shirodemo.user.dao;

import com.shiro.shirodemo.user.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName UserInfoDao
 * @Author qinqinjiang
 * @Date 2018/9/3 13:39
 * @Description
 */
public interface UserInfoDao extends JpaRepository<UserInfo, Long> {// PagingAndSortingRepository<UserInfo, Long>, QueryByExampleExecutor<UserInfo> {
    UserInfo findByUsername(String username);
    @Override
    List<UserInfo> findAll();
}
