package com.myself.springcloud.controller;

import com.myself.springcloud.entities.CommonResult;
import com.myself.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL="http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){

        return restTemplate.postForObject(PAYMENT_URL,"/payment/create",CommonResult.class);
    }
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        CommonResult result =null;
        String req="/payment/get/"+id;
        try{
             result = restTemplate.getForObject(PAYMENT_URL+req,CommonResult.class);
        }catch (Exception a){
            log.error(a.getMessage());
        }
        return result;
    }
}
