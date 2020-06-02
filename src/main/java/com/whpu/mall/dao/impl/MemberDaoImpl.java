package com.whpu.mall.dao.impl;

import com.whpu.mall.dao.MemberDao;
import com.whpu.mall.pojo.Member;
import com.whpu.mall.utils.DateUtil;
import com.whpu.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class MemberDaoImpl implements MemberDao {
    QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

    /**
     * 根据手机号密码查询用户
     * @param mobile
     * @param pwd
     * @return
     */
    @Override
    public Member findByMobileAndPwd(String mobile, String pwd) {
        String sql ="select * from member where mobile = ? and pwd = ?";
        Member member=null;
        try {
            member = runner.query(sql, new BeanHandler<>(Member.class), mobile, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }

    /**
     * 根据手机号查询用户
     * @param mobile
     * @return
     */
    @Override
    public Member findByMobile(String mobile) {
        String sql ="select * from member where mobile = ? ";
        Member member=null;
        try {
            member = runner.query(sql, new BeanHandler<>(Member.class), mobile);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }

    /**
     * 添加用户
     * @param member
     */
    @Override
    public void add(Member member) {
        String sql="insert into member values(null,?,?,?,?,?,?,?)";
        try {
            runner.update(sql,member.getMobile(),member.getPwd(),
                    member.getNick_name(),member.getReal_name(),
                    member.getEmail(),member.getGender(),
                    DateUtil.date2String(member.getRegister_time()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
