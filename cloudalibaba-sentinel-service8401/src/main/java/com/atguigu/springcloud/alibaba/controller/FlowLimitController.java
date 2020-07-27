package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitController
{
    @GetMapping("/testA")
    public String testA() throws InterruptedException {
        //Thread.sleep(6000);
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() throws InterruptedException {
        log.info("testB:"+Thread.currentThread().getName());
        return "------testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "handler_testHotKey")
    public String testHotKey(@RequestParam(value = "q1",required = false) String q1,
                             @RequestParam(value = "q2",required = false) String q2){
        return "------testHotKey";
    }

    public String handler_testHotKey(String q1, String q2, BlockException exception){
        return "------testHotKey o(╥﹏╥)o";
    }


}