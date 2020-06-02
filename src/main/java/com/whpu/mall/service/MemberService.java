package com.whpu.mall.service;

import com.whpu.mall.pojo.Member;

public interface MemberService {
    public Member login(String mobile,String pwd);

    public boolean regist(Member member);
}
