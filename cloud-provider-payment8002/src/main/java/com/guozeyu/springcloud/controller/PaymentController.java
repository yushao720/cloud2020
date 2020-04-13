package com.guozeyu.springcloud.controller;

import com.guozeyu.springcloud.entities.CommonResult;
import com.guozeyu.springcloud.entities.Payment;
import com.guozeyu.springcloud.service.PaymentService;
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

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*******插入结果:" + result);
        if(result>0) {
            return new CommonResult(200,"插入数据库成功,serverPost:" + serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*******插入结果:" + payment + "hahahahahahaha");
        if (payment != null) {
            return new CommonResult(200,"查询成功,serverPost:" + serverPort,payment);
        }else {
            return new CommonResult(444,"查询失败，该id不存在",null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

}
