package com.lovo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovo.dao.UserDao;
import com.lovo.domain.User;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	// 检查登录用户名和密码是否合法
	public boolean login(String username, String password) {
		List<User> records = userDao.findByName(username);
		boolean result = false;
		
		if (records != null) {
			for (User user : records) {
				String pwd = user.getPassword();
				if (pwd != null && pwd.equals(password)) {
					result = true;
					break;
				} 
			}
		}
		
		return result;
	}
	
	// 检查用户名是否存在
	public boolean isExist(String username) {
		List<User> records = userDao.findByName(username);// 取得用户对象
		
		if (records == null) {// 用户不存在
			return false;
		} 
		
		return true;
	}
	
	// 注册一个新用户
	public Integer register(User record) {
		//userDao.save(record);
		return record.getId();
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
