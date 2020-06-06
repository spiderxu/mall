package com.whpu.mall.dao;

import com.whpu.mall.pojo.Orders;

import java.sql.SQLException;

public interface OrderDao {
    /**
     * 添加订单时，将订单的id 返回
     * @param orders
     * @return
     */
    public int add(Orders orders);

    /**
     * 更新订单状态
     * @param status
     * @param orderNumber
     */
    void update(int status, String orderNumber) throws SQLException;
}
