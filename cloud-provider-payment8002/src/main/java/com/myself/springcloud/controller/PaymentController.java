package com.myself.springcloud.controller;

import com.myself.springcloud.entities.CommonResult;
import com.myself.springcloud.entities.Payment;
import com.myself.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("写入结果为"+result);
        if(result>0){
            return new CommonResult(200,serverPort+"插入数据库成功",result);
        }else {
            return new CommonResult(444,serverPort+"插入数据库失败",null);
        }
    }

    @GetMapping(value = "payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment paymentRuselt = paymentService.getPaymentById(id);
        log.info("查询结果为"+paymentRuselt);
        if(paymentRuselt !=null){
            return new CommonResult(200,serverPort+"查询成功",paymentRuselt);
        }else {
            return new CommonResult(444,serverPort+"没有找到对应记录，查询id:"+id,null);
        }
    }
}
