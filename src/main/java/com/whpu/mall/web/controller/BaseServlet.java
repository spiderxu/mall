package com.whpu.mall.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;


public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求地址
        StringBuffer requestURL = req.getRequestURL();
        //2.获取地址中最后的内容
        String substring = requestURL.substring(requestURL.lastIndexOf("/") + 1);

        //获取子类对象信息
        Class clazz = this.getClass();
        try {
            //获取子类的方法
            Method method = clazz.getMethod(substring, HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
