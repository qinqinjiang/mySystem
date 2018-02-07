package com.lovo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lovo.domain.User;
import com.lovo.mapper.UserMapper;

@Transactional
@Component
public class UserDaoImpl implements UserDao 
{   
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List findByName(String name) {
		List<User> users = userMapper.getUserByName(name);
		return users;
	}
	
	@Override
	public int addUser(User user) {
		int result = userMapper.addUser(user);
		return result;
	}
	
	public UserMapper getUserMapper() {
		return userMapper;
	}
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
} 
