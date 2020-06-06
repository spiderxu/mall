package com.whpu.mall.service.impl;

import com.whpu.mall.dao.ItemDao;
import com.whpu.mall.dao.OrderDao;
import com.whpu.mall.dao.ProductDao;
import com.whpu.mall.dao.impl.ItemDaoImpl;
import com.whpu.mall.dao.impl.OrderDaoImpl;
import com.whpu.mall.dao.impl.ProductDaoImpl;
import com.whpu.mall.pojo.Item;
import com.whpu.mall.pojo.Orders;
import com.whpu.mall.pojo.Product;
import com.whpu.mall.service.OrderService;

import java.sql.SQLException;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao=new OrderDaoImpl();
    ProductDao productDao=new ProductDaoImpl();
    ItemDao itemDao=new ItemDaoImpl();


    /**
     * 添加订单
     * @param orders
     * @param ids
     * @param amounts
     */
    @Override
    public void add(Orders orders, String[] ids, String[] amounts) {
        //添加订单，同时将订单的id返回
        int orderId = orderDao.add(orders);
        //添加订单项
        for(int i=0;i<ids.length;i++){
            //创建订单项对象
            Item item=new Item();
            item.setOrder_id(orderId);  //设置订单id
            item.setProduct_id(Integer.parseInt(ids[i]));
            item.setAmount(Integer.parseInt(amounts[i]));

            Product product=productDao.findProductById(Integer.parseInt(ids[i]));
            item.setTotal_price(product.getPrice()*Integer.parseInt(amounts[i]));
            item.setPayment_price(product.getSale_price()*Integer.parseInt(amounts[i]));

            itemDao.add(item);
        }
    }

    /**
     * 更新订单状态
     * @param status
     * @param orderNumber
     */
    @Override
    public void update(int status, String orderNumber) {
        try {
            orderDao.update(status,orderNumber);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
