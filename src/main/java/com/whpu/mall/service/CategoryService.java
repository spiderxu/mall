package com.whpu.mall.service;

import com.whpu.mall.pojo.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 查找所有商品分类
     * @return
     */
    public List<Category> findAll();

    /**
     * 通过Redis优化，提升性能
     * @return
     */
    public String findAllByRedis();
}
