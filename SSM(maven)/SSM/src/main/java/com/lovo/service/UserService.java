package com.lovo.service;

import com.lovo.domain.User;

public interface UserService {
	// 登录
	public boolean login(String username, String password);

/*	// 检查用户名是否存在
	public boolean isExist(String username);

	// 注册用户
	public Integer register(User record);*/
}
