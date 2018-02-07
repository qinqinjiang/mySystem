package com.lovo.dao;

import java.util.List;

import com.lovo.domain.User;

public interface UserDao {
//	 public User get(int id);
//	 public void save(User person);
//	 public void update(User person);
//	 public void delete(int id);
//	 public void delete(User person);
	 public List findByName(String name);
//	 public List findAllUser();
	 
	 public int addUser(User user);
}
