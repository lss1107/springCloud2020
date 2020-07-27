package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.entitles.CommonResult;
import com.atguigu.springcloud.entitles.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<Payment>(500,"服务端异常，兜底",null);
    }
}
