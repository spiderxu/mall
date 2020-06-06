package com.whpu.mall.web.controller;

import com.whpu.mall.common.Result;
import com.whpu.mall.pojo.Category;
import com.whpu.mall.service.CategoryService;
import com.whpu.mall.service.impl.CategoryServiceImpl;
import com.whpu.mall.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {
    CategoryService categoryService= new CategoryServiceImpl();

    /**
     * 查找所有商品的分类
     * @return
     */
    public void  findAll(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");

        String result = categoryService.findAllByRedis();
        response.getWriter().print(result);

    }
}
