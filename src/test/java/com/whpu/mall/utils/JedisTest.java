package com.whpu.mall.utils;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Map;

public class JedisTest {
    @Test
    public void test1(){
        Jedis jedis=new Jedis("localhost",6379);

        jedis.set("mystring","xiaoming");
        jedis.set("name","xx");
        jedis.close();
    }

    @Test
    public void testHash(){
        Jedis jedis=new Jedis();

        jedis.hset("myhash","name","dabao");
        jedis.hset("myhash","age","20");

        Map<String, String> map = jedis.hgetAll("myhash");
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String key=iterator.next();
            System.out.println(key+"===>"+map.get(key));
        }
        jedis.close();
    }
}
