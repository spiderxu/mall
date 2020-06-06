package com.whpu.mall.dao.impl;

import com.whpu.mall.dao.OrderDao;
import com.whpu.mall.pojo.Orders;
import com.whpu.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class OrderDaoImpl implements OrderDao {
    QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());

    /**
     * 添加订单 返回订单id
     * @param orders
     * @return
     */
    @Override
    public int add(Orders orders) {
        String sql="insert into orders values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int id=0;
        try {
            runner.update(sql, orders.getNumber(), orders.getBuyer_id(), orders.getTotal_amount(), orders.getTotal_price(), orders.getPayment_price(), orders.getRemark(), orders.getConcat(), orders.getMobile(), orders.getStreet(), orders.getZipcode(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orders.getCreate_time()), orders.getPayment_time(), orders.getDelivery_time(), orders.getEnd_time(), orders.getStatus());
            BigInteger lid=runner.query("select last_insert_id()",new ScalarHandler<BigInteger>());  //获取最近一次添加语句所产生的自增列的值

            id= lid.intValue();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * 更新订单状态
     * @param status
     * @param orderNumber
     */
    @Override
    public void update(int status, String orderNumber) throws SQLException {
        String sql="update orders set status= ? where Number = ?";
        runner.update(sql,status,orderNumber);

    }
}
