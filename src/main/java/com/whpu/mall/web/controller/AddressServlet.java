package com.whpu.mall.web.controller;

import com.whpu.mall.common.Result;
import com.whpu.mall.pojo.Address;
import com.whpu.mall.pojo.Member;
import com.whpu.mall.service.AddressService;
import com.whpu.mall.service.impl.AddressServiceImpl;
import com.whpu.mall.utils.JsonUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/address/*")
public class AddressServlet extends BaseServlet {
    AddressService addressService=new AddressServiceImpl();

    /**
     * 查询收获地址
     * @param request
     * @param response
     */
    public void findMemberAddress(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Member member =(Member) session.getAttribute("member");
        Integer id = member.getId();

        List<Address> addresses = addressService.findAddressByMemberId(id);

        Result result=new Result(true,addresses,"查询成功");
        JsonUtil.writeJson(response,result);

    }

    /**
     * 添加地址
     * @param request
     * @param response
     */
    public void saveAddress(HttpServletRequest request,HttpServletResponse response){
        Map<String, String[]> parameterMap = request.getParameterMap();
        Address address=new Address();
        try {
            BeanUtils.populate(address,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("member");
        //设置地址的会员编号
        address.setMbr_id(member.getId());

        addressService.addAddress(address);
        Result result=new Result(true,"添加成功");
        JsonUtil.writeJson(response,result);
    }
}
