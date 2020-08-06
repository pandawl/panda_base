package com.panda.pa.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;


/**
 * The type Jackson util.
 *
 * @author :wl
 * @date 09.09.2018
 */
@Slf4j
public class JacksonUtil {
    /**
     * The constant DEFAULT_DATE_FORMAT.
     */
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * The constant mapper.
     */
    private static ObjectMapper mapper;

    static {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        mapper = new ObjectMapper();
        mapper.setDateFormat(dateFormat);
    }

    /**
     * Map to jon string.
     *
     * @param object the object
     * @return the string
     */
    public static String mapToJon(Object object) {
        if (mapper == null) {
            mapper = new ObjectMapper();
        }
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("JSON转换错误:"+e.getMessage());
        }
        return null;
    }

    /**
     * List to jon string.
     *
     * @param list the list
     * @return the string
     */
    public static String listToJSON(List list) {
        if (mapper == null) {
            mapper = new ObjectMapper();
        }
        try {
            return mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            log.error("JSON转换错误:"+e.getMessage());

        }
        return null;
    }

    /**
     * Object to json string.
     *
     * @param object the object
     * @return the string
     */
    public static String objectToJson(Object object) {
        if (mapper == null) {
            mapper = new ObjectMapper();
        }

        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("JSON转换错误:"+e.getMessage());

        }
        return null;
    }

    /**
     * Map to pojo t.
     *
     * @param <T>   the type parameter
     * @param map   the map
     * @param clazz the clazz
     * @return the t
     */
    public static <T> T mapToPojo(Map map, Class<T> clazz) {
        return mapper.convertValue(map, clazz);
    }

    /**
     * Json to object t.
     *
     * @param <T>          the type parameter
     * @param jsonArrayStr the json array str
     * @param clazz        the clazz
     * @return the t
     */
    public static <T> T jsonToObject(String jsonArrayStr, Class<T> clazz) {
        try {
            return mapper.readValue(jsonArrayStr, clazz);
        } catch (IOException e) {
            log.error("JSON转换错误:"+e.getMessage());
            return null;
        }
    }




}
