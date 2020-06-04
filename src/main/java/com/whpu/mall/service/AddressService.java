package com.whpu.mall.service;

import com.whpu.mall.pojo.Address;

import java.util.List;

public interface AddressService {
    /**
     * 根据会员id查询会员的地址
     * @param id
     * @return
     */
    public List<Address> findAddressByMemberId(int id);

    /**
     * 增加地址
     * @param address
     */
    public void addAddress(Address address);

    /**
     * 根据address_id 查询地址信息
     * @param address_id
     * @return
     */
    Address findById(int address_id);
}
