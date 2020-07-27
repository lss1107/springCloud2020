package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.Order;

public interface OrderService {
    //新建订单
    void create(Order order);

}
