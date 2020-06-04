package com.whpu.mall.dao;

import com.whpu.mall.pojo.Item;

public interface ItemDao {
    /**
     * 添加订单项
     * @param item
     */
    void add(Item item);
}
