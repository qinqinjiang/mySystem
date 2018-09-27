package com.example.jpademo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Author qinqinjiang
 * @Date 2018/9/26 16:32
 * @Description
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/get/{id}")
    public Users findById(@PathVariable Long id){
        return userRepository.getOne(id);
    }

    @GetMapping("/list")
    public List<Users> usersList(){
        return userRepository.findAll();
    }
}
