package com.example.microservicecustomer.test;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName TestService
 * @Author qinqinjiang
 * @Date 2018/9/29 10:05
 * @Description
 */
@Service
public class TestService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public String testHystrix(){
        return restTemplate.getForEntity("http://PROVIDER/test",String.class).getBody();
    }

    public String error(){
        return "hystrixError";
    }
}
