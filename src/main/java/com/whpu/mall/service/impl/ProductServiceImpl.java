package com.whpu.mall.service.impl;

import com.whpu.mall.common.PageBean;
import com.whpu.mall.dao.ProductDao;
import com.whpu.mall.dao.impl.ProductDaoImpl;
import com.whpu.mall.pojo.Product;
import com.whpu.mall.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao=new ProductDaoImpl();


    /**
     * 根据商品分类id，查找该分类是所有商品，分页展示
     * @param cateId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<Product> findPage(int cateId, int currentPage, int pageSize) {
        //1.接收当前分类商品总数量
        long totalCount = productDao.findTotalCount(cateId);
        //2.计算分页数量
        long totalPage = totalCount%pageSize==0? (totalCount/pageSize):(totalCount/pageSize )+1;

        if(currentPage<=0){ //用户传来的页数小于0
            currentPage=1;
        }
        if(currentPage>totalPage){  //用户传来的页数大于总页数
            currentPage=Integer.parseInt(totalPage+"");
        }


        int start=(currentPage-1)*pageSize;  //使用limit分页起始坐标
        //3.接收当前页面商品数据集合
        List<Product> products = productDao.findByPage(cateId, start, pageSize);

        PageBean<Product> pageBean=new PageBean<>();
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(products);
        pageBean.setCurrentPage(currentPage);
        return pageBean;
    }

    /**
     * 查询面包屑导航栏信息
     * @param cateId
     * @return
     */
    @Override
    public String findNavicate(int cateId) {
        return productDao.findCategoryNameByID(cateId);
    }

    /**
     * 根据商品id查询商品详细信息
     * @param id
     * @return
     */
    @Override
    public Product findDetailById(int id) {
        return productDao.findProductById(id);
    }
}
