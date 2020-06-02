package com.whpu.mall.web.controller;

import com.whpu.mall.common.Result;
import com.whpu.mall.pojo.CartItem;
import com.whpu.mall.pojo.Product;
import com.whpu.mall.service.ProductService;
import com.whpu.mall.service.impl.ProductServiceImpl;
import com.whpu.mall.utils.JsonUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart/*")
public class CartServlet extends BaseServlet {
    ProductService productService=new ProductServiceImpl();
    /**
     * 添加商品到购物车，以session形式的存储
     * @param request
     * @param response
     */
    public void addCart(HttpServletRequest request, HttpServletResponse response){
        int productId = Integer.parseInt(request.getParameter("productId"));
        int number = Integer.parseInt(request.getParameter("number"));

        //获取商品
        Product product = productService.findDetailById(productId);
        CartItem cartItem=new CartItem(product,number);

        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>)session.getAttribute("cart");

        if(cart==null){
            cart=new ArrayList<>();
        }
        cart.add(cartItem);
        session.setAttribute("cart",cart);

        Result result=new Result(true,"添加成功");
        JsonUtil.writeJson(response,result);



    }
}
