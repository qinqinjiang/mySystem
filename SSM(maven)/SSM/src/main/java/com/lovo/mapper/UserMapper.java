package com.lovo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.lovo.domain.User;

public interface UserMapper extends SqlMapper{
	//查询指定用户
	public List<User> getUserByName(String username);
	
	@Insert("insert into user values(null,#{username},#{password},#{email})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	
	public int addUser(User user);
}
