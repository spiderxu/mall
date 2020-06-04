package com.whpu.mall.dao;

import com.whpu.mall.pojo.Orders;

public interface OrderDao {
    /**
     * 添加订单时，将订单的id 返回
     * @param orders
     * @return
     */
    public int add(Orders orders);
}
