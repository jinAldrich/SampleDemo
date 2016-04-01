package com.yujin.demo.utils;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by yujin on 16/3/31.
 */
public class GsonUtil {

    /**
     * entity-json
     * @param object
     * @return
     */
    public static String toJson(Object object){
        String obj="";
        try {
            Gson gson=new Gson();
            obj=gson.toJson(object).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
    /**
     * json-entity
     * @param jsonString
     * @param cls
     * @return
     */
    public static  <T> Object toObject(String jsonString,Class<T> cls ){
        Gson gson = new Gson();
        Object  object = gson.fromJson(jsonString, cls);
        return object;
    }

    public static String toJson(ArrayList<Object> list){
        String json="[";
        try {
            for(Object obj:list){
                json=json+"{"+obj+"}";
            }
            json=json+"]";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
