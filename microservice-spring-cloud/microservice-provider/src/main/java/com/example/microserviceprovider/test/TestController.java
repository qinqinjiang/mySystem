package com.example.microserviceprovider.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Author qinqinjiang
 * @Date 2018/9/28 18:09
 * @Description
 */
@RestController
public class TestController{
    @GetMapping("test")
    public String test() throws Exception{
        Thread.sleep(3000);
        return "服务提供者被调用";
    }

    @RequestMapping("testFeignProvider")
    public String testFeign(){
        return "testFeignProvider";
    }
}
