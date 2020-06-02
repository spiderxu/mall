package com.whpu.mall.dao;

import com.whpu.mall.pojo.Category;

import java.util.List;

public interface CategoryDao {
    /**
     * 查询所有商品的分类
     * @return
     */
    public List<Category> findAll();


}
