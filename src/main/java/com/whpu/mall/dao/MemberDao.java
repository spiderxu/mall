package com.whpu.mall.dao;

import com.whpu.mall.pojo.Member;

public interface MemberDao {
    /**
      根据手机号和密码查询用户
     */
    public Member findByMobileAndPwd(String mobile, String pwd);

    /**
     * 根据手机号查询用户
     */
    public Member findByMobile(String mobile);

    /**
     * 添加用户
     */
    public void add(Member member);
}
