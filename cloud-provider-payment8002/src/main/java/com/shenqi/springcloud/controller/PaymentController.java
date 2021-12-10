package com.shenqi.springcloud.controller;

import com.shenqi.springcloud.entities.CommonResult;
import com.shenqi.springcloud.entities.Payment;
import com.shenqi.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult createPayment(@RequestBody Payment payment) {
        System.out.println("payment = " + payment);
        int result = paymentService.create(payment);
        log.info("**** 插入结果 ****" + result);

        if (result > 0) return new CommonResult(200, "插入数据成功， serverPort = " + serverPort, result);
        else return new CommonResult(444, "插入数据失败， serverPort = " + serverPort);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment paymentBean = paymentService.getPaymentById(id);
        log.info("**** 查询结果 ****" + paymentBean);

        if(paymentBean != null) return new CommonResult(200, "查询成功， serverPort = " + serverPort, paymentBean);
        else return new CommonResult(444, "没有对应记录，查询 ID = " + id + " ， serverPort = " + serverPort, null);
    }

}
