package com.whpu.mall.dao.impl;

import com.whpu.mall.dao.ProductDao;
import com.whpu.mall.pojo.Product;
import com.whpu.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());

    /**
     * 查询该分类下的商品总数
     * @param cateId
     * @return
     */
    @Override
    public long findTotalCount(int cateId) {
        String sql="select count(*) from product where cate_id = ?";
        Long query=0L;
        try {
             query = runner.query(sql, new ScalarHandler<Long>(), cateId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    /**
     * 分页查询数据，使用limit
     * @param cateId
     * @param start
     * @param pageSize
     * @return
     */
    @Override
    public List<Product> findByPage(int cateId, int start, int pageSize) {
        String sql ="select * from product where cate_id=? limit ?,?";

        List<Product> products=null;
        try {
            products = runner.query(sql, new BeanListHandler<>(Product.class), cateId, start, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }


    /**
     * 根据分类id查询分类名称
     * @param id
     * @return
     */
    @Override
    public String findCategoryNameByID(int id) {
        String sql="select distinct category.name from category,product where product.cate_id=? and category.id = product.cate_id";
        String name=null;
        try {
            name = runner.query(sql, new ScalarHandler<String>(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    /**
     * 根据商品id查询商品详细信息
     * @param id
     * @return
     */
    @Override
    public Product findProductById(int id)  {
        String sql="select * from product where id= ?";
        Product product=null;
        try {
            product = runner.query(sql, new BeanHandler<>(Product.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
