package com.wode.dao;


import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

import com.wode.entity.UserEntity;

/**
 * JPA接口
 * @author jiangqinqin
 *
 */
@RepositoryDefinition(domainClass=UserEntity.class,idClass=Integer.class)
public interface IUserRepository{ // extends Repository<UserEntity,Integer>
	//查询用户信息
	UserEntity findById(Integer id);
}
