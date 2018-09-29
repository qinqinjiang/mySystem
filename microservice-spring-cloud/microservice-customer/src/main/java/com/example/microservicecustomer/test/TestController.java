package com.example.microservicecustomer.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName TestController
 * @Author qinqinjiang
 * @Date 2018/9/28 17:25
 * @Description
 */
@RestController
public class TestController {
    @Autowired
    private DiscoveryClient client;

    @Autowired
    private TestService testService;

    @Resource
    private ProviderFeignService providerFeignService;

    @GetMapping("test")
    public String test() {
        List<ServiceInstance> list = client.getInstances("provider");
        ServiceInstance instance = list.get(0);
        System.out.println("host:" + instance.getHost() + "    port:"+instance.getPort() +"  uri:"+instance.getUri());
        return testService.testHystrix();
    }

    @RequestMapping("testFeign")
    public String testFeign(){
        return providerFeignService.testFeign();
    }
}
