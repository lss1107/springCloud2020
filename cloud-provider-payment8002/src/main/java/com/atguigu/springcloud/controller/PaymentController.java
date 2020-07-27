package com.atguigu.springcloud.controller;
import com.atguigu.springcloud.entitles.CommonResult;
import com.atguigu.springcloud.entitles.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入数据结果："+result);
        if (result>0){
            return new CommonResult(200,"创建成功,Port:"+port,result);
        }else {
            return new CommonResult(444,"创建失败",null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("*****查询结果："+result);
        if (result!=null){
            return new CommonResult(200,"查询成功,Port:"+port,result);
        }else {
            return new CommonResult(444,"查询失败，没有对应的记录"+id,null);
        }
    }
}
