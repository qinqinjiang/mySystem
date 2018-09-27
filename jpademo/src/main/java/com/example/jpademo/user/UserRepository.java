package com.example.jpademo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserRepository
 * @Author qinqinjiang
 * @Date 2018/9/26 15:52
 * @Description
 */
@Component
public interface UserRepository extends JpaRepository<Users,Long> {

}
