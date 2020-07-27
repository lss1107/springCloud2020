package com.atguigu.springcloud.alibaba.controller.blockHander;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entitles.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException exception){
        return new CommonResult(444,"来到了自定义限流处理*****"+exception.getClass().getName());
    }

    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(666,"来到了自定义限流处理2*****"+exception.getClass().getName());
    }
}
