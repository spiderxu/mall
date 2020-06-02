package com.whpu.mall.utils;

import com.whpu.mall.pojo.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class DButilsTest {

    //测试聚集函数
    @Test
    public void test01() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        String sql="select count(*) from category";

        Long count = runner.query(sql, new ScalarHandler<Long>());
        System.out.println(count);
    }

    //测试查询
    @Test
    public void test02() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        String sql="select * from category";
        List<Category> categoryList = runner.query(sql, new BeanListHandler<>(Category.class));

        for (Category category : categoryList) {
            System.out.println(category);
        }
    }

    //测试增加
    @Test
    public void test03(){
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        String sql="insert into category values(null,?,?,?)";

        try {
            runner.update(sql,"日用百货","riyongbaihuo",10);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //测试修改
    @Test
    public void test04(){
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        String sql="update category set name=?,alias=? where id=?";

        try {
            runner.update(sql,"日用百货1","riyongbaihuo1",28);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //测试删除
    @Test
    public void test05(){
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        String sql="delete from category where id=?";

        try {
            runner.update(sql,28);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
