package com.whpu.mall.service.impl;

import com.whpu.mall.dao.CategoryDao;
import com.whpu.mall.dao.impl.CategoryDaoImpl;
import com.whpu.mall.pojo.Category;
import com.whpu.mall.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao=new CategoryDaoImpl();

    /**
     * 查询所有商品分类
     * @return
     */
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
