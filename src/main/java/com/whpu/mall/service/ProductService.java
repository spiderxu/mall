package com.whpu.mall.service;

import com.whpu.mall.common.PageBean;
import com.whpu.mall.pojo.Product;

import java.util.List;

public interface ProductService {



    /**
     * 根据商品的分类id,查找属于该分类的所有商品。并分页展示
     * @param cateId
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageBean<Product> findPage(int cateId, int currentPage,int pageSize);

    /**
     * 查询面包屑导航栏信息
     * @param cateId
     * @return
     */
    public String findNavicate(int cateId);

    /**
     * 根据商品id查询商品的细节
     * @param id
     * @return
     */
    public Product findDetailById(int id);

}
