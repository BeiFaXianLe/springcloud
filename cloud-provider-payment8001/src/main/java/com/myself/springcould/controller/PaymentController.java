package com.myself.springcould.controller;

import com.myself.springcould.entities.CommonResult;
import com.myself.springcould.entities.Payment;
import com.myself.springcould.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("写入结果为"+result);
        if(result>0){
            return new CommonResult(200,"插入数据库成功",result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果为"+payment);
        if(payment !=null){
            return new CommonResult(200,"查询成功",payment);
        }else {
            return new CommonResult(444,"没有找到对应记录，查询id:"+id,null);
        }
    }
}
