package com.whpu.mall.service.impl;

import com.whpu.mall.dao.MemberDao;
import com.whpu.mall.dao.impl.MemberDaoImpl;
import com.whpu.mall.pojo.Member;
import com.whpu.mall.service.MemberService;

public class MemberServiceImpl implements MemberService {
    MemberDao memberDao=new MemberDaoImpl();

    /**
     * 用户登录
     * @param mobile
     * @param pwd
     * @return
     */
    @Override
    public Member login(String mobile, String pwd) {
        Member member = memberDao.findByMobileAndPwd(mobile, pwd);
        return member;
    }

    /**
     * 用户注册
     * @param member
     * @return
     */
    @Override
    public boolean regist(Member member) {
        //判断手机号是否存在
        Member mobile = memberDao.findByMobile(member.getMobile());
        if(mobile!=null){
            return false;
        }
        //如果不存在完成添加操作
        memberDao.add(member);
        return true;
    }
}
