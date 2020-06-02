package com.whpu.mall.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonUtil {
    //将对象转成JSon格式
    public static void writeJson(HttpServletResponse response, Object object){
        response.setContentType("application/json; charset=utf-8");

        ObjectMapper mapper=new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(object);
            response.getWriter().print(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
