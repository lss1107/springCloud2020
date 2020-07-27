package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entitles.CommonResult;
import com.atguigu.springcloud.entitles.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001"; 服务提供者是单机版
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";//集群服务的应用名称

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment){
       return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin/", String.class);
        return result;
    }

}


