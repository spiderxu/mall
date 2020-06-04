package com.whpu.mall.service.impl;

import com.whpu.mall.dao.AddressDao;
import com.whpu.mall.dao.impl.AddressDaoImpl;
import com.whpu.mall.pojo.Address;
import com.whpu.mall.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {

    AddressDao addressDao=new AddressDaoImpl();

    /**
     * 根据会员id查询会员地址
     * @param id
     * @return
     */
    @Override
    public List<Address> findAddressByMemberId(int id) {
        return addressDao.findAddressByMemberId(id);
    }

    /**
     * 增加地址
     * @param address
     */
    @Override
    public void addAddress(Address address) {
        if(address.getDefault_value()==0){
            addressDao.addAddress(address);
        }else{
            //如果是默认地址，需要将会员对应的地址改为改地址
            addressDao.updateDefaultValue(address.getMbr_id());
            addressDao.addAddress(address);
        }

    }

    /**
     * 根据address_id查询地址信息
     * @param address_id
     * @return
     */
    @Override
    public Address findById(int address_id) {
        return addressDao.findById(address_id);

    }
}
