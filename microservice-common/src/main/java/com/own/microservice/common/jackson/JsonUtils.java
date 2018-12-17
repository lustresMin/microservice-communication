package com.own.microservice.common.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义JSON响应结构
 *
 * @auther: mc
 * @date: 2018/4/17 14:37
 * @projectName: parent
 * @version: 1.0
 */
public class JsonUtils {
    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串
     * Title: pojoToJson
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     * @param jsonData json数据
     * @param beanType 对象中的object类型
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 将json数据转换成pojo对象list
     * @param jsonData
     * @param beanType
     * @param <T>
     * @return
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    /**
     * json string convert to map
     * <br>json字符串转换为Map<String, Object>对象
     */
    public static <T> Map<String, Object> jsonToMap(String jsonStr)
            throws Exception {
        return MAPPER.readValue(jsonStr, Map.class);
    }

    /**
     * json string convert to map<map> , convert to map with javaBean
     * <br>json字符串转换为Map<String, Object>对象,然后再转换为Map<String, T>对象
     */
    public static <T> Map<String, T> jsonToMap(String jsonStr, Class<T> clazz)
            throws Exception {
        Map<String, Map<String, Object>> map = MAPPER.readValue(jsonStr,
                new TypeReference<Map<String, T>>() {
                });
        Map<String, T> result = new HashMap<String, T>();
        for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
            result.put(entry.getKey(), mapToPojo(entry.getValue(), clazz));
        }
        return result;
    }

    /**
     * map convert to javaBean
     * <br>Map<String, Object>对象转换为<T>实体类对象
     */
    public static <T> T mapToPojo(Map map, Class<T> clazz) {
        return MAPPER.convertValue(map, clazz);
    }

    /**
     * json array string convert to list<map<String,Obj>>,convert to list<T> with javaBean
     * <br>json字符串转换为Map<String, Object>对象,然后再转换为List<T>对象
     */
    public static <T> List<T> jsonToMapToList(String jsonArrayStr, Class<T> clazz)
            throws Exception {
        List<Map<String, Object>> list = MAPPER.readValue(jsonArrayStr,
                new TypeReference<List<T>>() {
                });
        List<T> result = new ArrayList<T>();
        for (Map<String, Object> map : list) {
            result.add(mapToPojo(map, clazz));
        }
        return result;
    }

}
