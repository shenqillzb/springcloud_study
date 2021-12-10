package com.shenqi.springcloud.controller;

import com.shenqi.springcloud.entities.CommonResult;
import com.shenqi.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    // httpClient
    // restTemplate：提供了多种便捷访问远程 Http 服务方法，是一种简单便捷的访问 restful 服务模版类，是 Spring 提供的用于访问 Rest 服务的客户端模版工具集

    // 单机版可以这么写，但微服务集群版不能这么写
    // public static final String PAYMENT_URL = "http://localhost:8001";

    // 集群版
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE"; // CLOUD-PAYMENT-SERVICE 是 Eureka Server 上注册的名称

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        System.out.println("payment" + payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

}
