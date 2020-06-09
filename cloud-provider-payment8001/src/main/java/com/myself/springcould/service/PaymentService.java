package com.myself.springcould.service;

import com.myself.springcould.entities.Payment;
import org.apache.ibatis.annotations.Param;


public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(Long id);
}
