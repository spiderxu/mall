package com.whpu.mall.web.controller;

import com.whpu.mall.common.PageBean;
import com.whpu.mall.common.Result;
import com.whpu.mall.pojo.Product;
import com.whpu.mall.service.ProductService;
import com.whpu.mall.service.impl.ProductServiceImpl;
import com.whpu.mall.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product/*")
public class ProductServlet extends BaseServlet {
    ProductService productService=new ProductServiceImpl();

    /**
     * 查询某一分类的所有商品，并且分类展示
     * @param request
     * @param response
     */
    public void findPage(HttpServletRequest request,HttpServletResponse response){
        //1.获取分类id
        String cate_id = request.getParameter("categoryId");
        int cateId=0;
        if(cate_id!=null){
            cateId=Integer.parseInt(cate_id);
        }
        //2.获取当前页面编号
        String page = request.getParameter("currentPage");
        int currentPage=1;
        if(page!=null){
            currentPage=Integer.parseInt(page);
        }
        //3.获取每页数量
        String size= request.getParameter("pageSize");
        int pageSize=10;
        if(size!=null){
            pageSize=Integer.parseInt(size);
        }

        PageBean<Product> pageBean = productService.findPage(cateId, currentPage, pageSize);
        JsonUtil.writeJson(response,pageBean);


    }

    /**
     * 面包屑导航栏的修改
     * @param request
     * @param response
     */
    public void findNavicate(HttpServletRequest request,HttpServletResponse response){
        String categoryId = request.getParameter("categoryId");
        int id=0;
        if(categoryId!=null){
            id=Integer.parseInt(categoryId);
        }
        String navicate = productService.findNavicate(id);
        Result result=new Result(true,navicate,"查找成功");
        JsonUtil.writeJson(response,result);
    }

    /**
     * 查询商品细节
     * @param request
     * @param response
     */
    public void findProductDetail(HttpServletRequest request,HttpServletResponse response){
        //获取前端传来的id
        String productId = request.getParameter("productId");
        int id=Integer.parseInt(productId);
        Product detail = productService.findDetailById(id);

        Result result=new Result(true,detail,"查询成功");
        JsonUtil.writeJson(response,result);
    }

    /**
     * 增加商品
     */
    public void add(HttpServletRequest request,HttpServletResponse response){

    }
}
