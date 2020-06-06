package com.whpu.mall.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whpu.mall.dao.CategoryDao;
import com.whpu.mall.dao.impl.CategoryDaoImpl;
import com.whpu.mall.pojo.Category;
import com.whpu.mall.service.CategoryService;
import com.whpu.mall.utils.JedisUtil;
import com.whpu.mall.utils.JsonUtil;
import redis.clients.jedis.Jedis;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao=new CategoryDaoImpl();

    /**
     * 查询所有商品分类
     * @return
     */
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    /**
     * 使用Redis查询优化
     * @return
     */
    @Override
    public String findAllByRedis() {
        Jedis jedis= JedisUtil.getJedis();

        //1.判断缓存中是否有分类信息
        String category = jedis.get("CATEGORY");
        if(category==null||category.length()==0){
            List<Category> all = categoryDao.findAll();
            ObjectMapper mapper=new ObjectMapper();
            try {
                category = mapper.writeValueAsString(all);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("CATEGORY",category);
            System.out.println("访问mysql数据库");
            return category;
        }else{
            System.out.println("访问Redis数据库");
            return category;
        }

    }
}
