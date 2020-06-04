package com.whpu.mall.dao.impl;

import com.whpu.mall.dao.AddressDao;
import com.whpu.mall.pojo.Address;
import com.whpu.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AddressDaoImpl implements AddressDao {
    QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());

    /**
     * 根据会员id 查询会员地址
     * @param id
     * @return
     */
    @Override
    public List<Address> findAddressByMemberId(int id) {
        String sql="select * from address where mbr_id=?";
        List<Address> addresses=null;
        try {
             addresses = runner.query(sql, new BeanListHandler<>(Address.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    /**
     * 添加地址
     * @param address
     */
    @Override
    public void addAddress(Address address) {
        String sql="insert into address values(null,?,?,?,?,?,?)";
        try {
            runner.update(sql,address.getContact(),address.getMobile(),address.getStreet(),
                    address.getZipcode(),address.getMbr_id(),address.getDefault_value());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * 更改默认地址
     * @param memberId
     */
    @Override
    public void updateDefaultValue(int memberId) {
        String sql = "update address set default_value=0 where mbr_id=?";
        try {
            runner.update(sql,memberId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据address_id 查询地址信息
     * @param address_id
     * @return
     */
    @Override
    public Address findById(int address_id) {
        String sql="select * from address where id = ?";
        Address address=null;
        try {
            address = runner.query(sql, new BeanHandler<>(Address.class), address_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }
}
