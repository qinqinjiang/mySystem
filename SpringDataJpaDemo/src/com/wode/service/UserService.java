package com.wode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wode.dao.IUserRepository;
import com.wode.entity.UserEntity;

@Service
@Transactional
public class UserService {
	@Autowired
	private IUserRepository userRepository;
	
	public UserEntity findUserById(Integer id){
		UserEntity userEntity = userRepository.findById(id);
		return userEntity;
	}
}
