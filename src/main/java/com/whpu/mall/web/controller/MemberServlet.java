package com.whpu.mall.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whpu.mall.common.Result;
import com.whpu.mall.pojo.Member;
import com.whpu.mall.service.MemberService;
import com.whpu.mall.service.impl.MemberServiceImpl;
import com.whpu.mall.utils.JsonUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

@WebServlet("/member/*")
public class MemberServlet extends BaseServlet {
    MemberService memberService=new MemberServiceImpl();

    /**
     * 会员登录
     * @param request
     * @param response
     * @throws IOException
     */
    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //1。接收用户传过来的手机号和密码
        String mobile = request.getParameter("mobile");
        String pwd = request.getParameter("pwd");

        //2.判断手机号和密码是否正确
        Member member = memberService.login(mobile, pwd);

        //3.1登录失败
        Result result=new Result();
        if(member==null){
            result.setFlag(false);
            result.setData(null);
            result.setMsg("登录失败");

        }else{   //3.2登录成功
            result.setFlag(true);
            result.setData(null);
            result.setMsg("登录成功");
            HttpSession session = request.getSession();
            session.setAttribute("member",member);

        }

        //转成json
        JsonUtil.writeJson(response,result);
    }

    /**
     * 会员退出
     * @param request
     * @param response
     * @throws IOException
     */
    public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        session.invalidate();   //销毁session


        Result result=new Result();
        result.setFlag(true);
        //转成json
        JsonUtil.writeJson(response,result);
    }

    /**
     * 会员注册
     * @param request
     * @param response
     * @throws IOException
     */
    public void register(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //如果当前台的数据很多的时候，可以使用BeanUtils.Populdate()方法快速的将表单中的数据
        //封装到实体对象中，前题要保存表单数据的名字要实体对象的属性名一致
        Map<String, String[]> parameterMap = request.getParameterMap();
        Member member=new Member();
        try {
            BeanUtils.populate(member,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //设置用户注册时间
        member.setRegister_time(new Date());
        //调用业务层完成是否注册
        boolean isRegist=memberService.regist(member);
        Result result=new Result();
        if(isRegist==true){
            result.setFlag(true);
            result.setMsg("注册成功");
        }else {
            result.setFlag(false);
            result.setMsg("注册失败,用户名已存在");
        }

        JsonUtil.writeJson(response,result);
    }

    /**
     * 查询会员昵称
     * @param request
     * @param response
     * @throws IOException
     */
    public  void findNickName(HttpServletRequest request,HttpServletResponse response) throws IOException {

        HttpSession session=request.getSession();
        PrintWriter out=response.getWriter();

        Member member = (Member)session.getAttribute("member");
        //返回结果对象
        Result result=new Result();
        result.setFlag(true);
        result.setData(member);
        result.setMsg("");

        //转成Json
        JsonUtil.writeJson(response,result);

    }
}
