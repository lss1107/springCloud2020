package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.service.PaymentService;
import com.atguigu.springcloud.entitles.CommonResult;
import com.atguigu.springcloud.entitles.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CircleBreakerFeignController {

    @Resource
    private PaymentService paymentService;

    @RequestMapping("/consumer/feignFallback/{id}")
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        return paymentService.paymentSQL(id);
    }
}
 