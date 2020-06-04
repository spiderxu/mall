package com.whpu.mall.dao.impl;

import com.whpu.mall.dao.ItemDao;
import com.whpu.mall.pojo.Item;
import com.whpu.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class ItemDaoImpl implements ItemDao {
    QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());

    /**
     * 增加订单项
     * @param item
     */
    @Override
    public void add(Item item) {
        String sql = "insert into item values(null,?,?,?,?,?)";
        try {
            runner.update(sql,item.getOrder_id(),item.getProduct_id(),item.getAmount(),item.getTotal_price(),item.getPayment_price());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
