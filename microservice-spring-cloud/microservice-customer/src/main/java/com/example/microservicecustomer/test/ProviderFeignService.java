package com.example.microservicecustomer.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @InterfaceName ProviderFeignService
 * @Author qinqinjiang
 * @Date 2018/9/29 10:51
 * @Description
 */
@FeignClient("provider")
public interface ProviderFeignService {
    @RequestMapping("/testFeignProvider")
    String testFeign();
}
