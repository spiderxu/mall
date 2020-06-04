package com.whpu.mall.service;

import com.whpu.mall.pojo.Orders;

public interface OrderService {
    /**
     * 添加订单，同时添加订单项
     * @param orders
     * @param ids
     * @param amounts
     */
    public void add(Orders orders,String[] ids,String[] amounts);
}
