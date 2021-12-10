package com.shenqi.springcloud.service;

import com.shenqi.springcloud.entities.Payment;

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);

}
