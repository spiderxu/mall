package com.whpu.mall.dao;

import com.whpu.mall.pojo.Product;

import java.util.List;

public interface ProductDao {


    /**
     * 查询当前分类商品的总记录数
     * @param cateId
     * @return
     */
    public long findTotalCount(int cateId);

    /**
     * 查询当前页的商品信息
     * @param cateId
     * @param currentPage
     * @param pageSize
     * @return
     */
    public List<Product> findByPage(int cateId, int currentPage, int pageSize);

    /**
     * 根据分类id查询分类名称，面包屑导航栏
     */
    public String findCategoryNameByID(int id);

    /**
     * 根据id查询商品信息
     * @param id
     * @return
     */
    public Product findProductById(int id);
}
