package com.whpu.mall.web.controller;

import com.whpu.mall.common.Result;
import com.whpu.mall.pojo.*;
import com.whpu.mall.service.AddressService;
import com.whpu.mall.service.OrderService;
import com.whpu.mall.service.ProductService;
import com.whpu.mall.service.impl.AddressServiceImpl;
import com.whpu.mall.service.impl.OrderServiceImpl;
import com.whpu.mall.service.impl.ProductServiceImpl;
import com.whpu.mall.utils.JsonUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/order/*")
public class OrderServlet extends BaseServlet {

    ProductService productService=new ProductServiceImpl();
    AddressService addressService=new AddressServiceImpl();
    OrderService orderService=new OrderServiceImpl();

    /**
     * 确认订单
     * @param request
     * @param response
     */
    public void confirmOrder(HttpServletRequest request, HttpServletResponse response){
        String[] ids = request.getParameter("ids").split(",");
        String[] amounts = request.getParameter("amounts").split(",");

        List<CartItem> orderList=new ArrayList<>();
        for(int  i=0;i<ids.length;i++){
            String id=ids[i];
            String amount=amounts[i];
            Product product = productService.findDetailById(Integer.parseInt(id));
            CartItem cartItem=new CartItem(product,Integer.parseInt(amount));
            orderList.add(cartItem);
        }
        Result result=new Result(true,orderList,"查询成功");
        JsonUtil.writeJson(response,result);

    }

    /**
     * 提交订单
     * @param request
     * @param response
     */
    public void submitOrder(HttpServletRequest request,HttpServletResponse response){
       //获取前台传过来的地址编号
        String address_id = request.getParameter("address_id");

        //获取商品的编号和数量
        String[] ids = request.getParameterValues("ids");
        String[] amounts = request.getParameterValues("amounts");

        //获取买家的留言
        String remark = request.getParameter("remark");

        //创建一个订单对象
        Orders orders=new Orders();
        orders.setStatus(0);
        //产生订单号
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String orderNumber = sdf.format(new Date());
        orders.setNumber(orderNumber);

        //获取订单地址信息
        Address address=addressService.findById(Integer.parseInt(address_id));
        orders.setConcat(address.getContact());
        orders.setZipcode(address.getZipcode());
        orders.setStreet(address.getStreet());
        orders.setMobile(address.getMobile());

        //设置买家的编号
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");
        orders.setBuyer_id(member.getId());
        //设置备注
        orders.setRemark(remark);
        //设置订单生效日期
        orders.setCreate_time(new Date());

        int totalAmount=0; //总数量
        double totalPrice=0;  //总价格
        double totalPayPrice=0; //实际支付的总价格
        //获取商品的信息
        for(int i=0;i<ids.length;i++){
            Product product = productService.findDetailById(Integer.parseInt(ids[i]));
            int amount = Integer.parseInt(amounts[i]);
            totalAmount+=amount;
            totalPrice+=product.getPrice()*amount;
            totalPayPrice+=product.getSale_price()*amount;
        }
        orders.setPayment_price(totalPayPrice);
        orders.setTotal_price(totalPrice);
        orders.setTotal_amount(totalAmount);

        //添加订单

        orderService.add(orders,ids,amounts);
        Result result=new Result(true,orders,"订单生成成功");
        JsonUtil.writeJson(response,result);

    }
}
