package com.whpu.mall.dao.impl;

import com.whpu.mall.dao.CategoryDao;
import com.whpu.mall.pojo.Category;
import com.whpu.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());

    /**
     * 查找所有商品的分类
     * @return
     */
    @Override
    public List<Category> findAll() {
        String sql="select * from category";
        try {
            List<Category> query = runner.query(sql, new BeanListHandler<>(Category.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
