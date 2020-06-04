package com.whpu.mall.dao;

import com.whpu.mall.pojo.Address;

import java.util.List;

public interface AddressDao {
    /**
     * 根据会员id查询会员地址
     * @param id
     * @return
     */
    public List<Address> findAddressByMemberId(int id);

    /**
     * 添加地址
     * @param address
     */
    void addAddress(Address address);

    /**
     * 更改默认地址
     * @param memberId
     */
    void updateDefaultValue(int memberId);

    /**
     * 根据address_id 查询地址信息
     * @param address_id
     * @return
     */
    Address findById(int address_id);
}
