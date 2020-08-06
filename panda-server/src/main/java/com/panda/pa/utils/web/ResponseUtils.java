package com.panda.pa.utils.web;


import com.panda.pa.utils.model.DataModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求和响应工具类
 *
 * @author :wl
 * @date Created on 2018-05-27
 */
@Slf4j
public class ResponseUtils {
    /**
     * Is ajax boolean.
     *
     * @param request the request
     * @return the boolean
     */
    public static Boolean isAjax(HttpServletRequest request) {
        String headerB = request.getHeader("X-Requested-With");
        boolean result = (headerB != null && "XMLHttpRequest".equalsIgnoreCase(headerB));
        log.debug("请求类型判断:XMLHttpRequest:" + headerB + ",result:" + result);
        return result;
    }

    /**
     * 判断一个请求是否是json请求
     *
     * @param request the request
     * @return the boolean
     */
    public static Boolean isJson(HttpServletRequest request) {
        String header = request.getHeader("Accept");
        String headerA = request.getHeader("Content-Type");
        String headerB = request.getHeader("X-Requested-With");
        boolean result = (header != null && header.contains("json")) ||
                headerA != null && headerA.contains("json") ||
                headerB != null && "XMLHttpRequest".equalsIgnoreCase(headerB);
        log.debug("JSON请求类型判断=Accept:" + header + ",Content-Type:" + headerA + ",XMLHttpRequest:" + headerB + ",JSON:" + result);
        return result;
    }

    /**
     * 返回处理成功消息
     *
     * @return the response entity 返回默认成功消息
     */
    public static ResponseEntity ok() {
        return ResponseEntity.ok(new DataModel<>().ok("处理成功"));
    }

    /**
     * 返回处理成功消息
     *
     * @param msg  the msg 返回消息
     * @param data the data 带的数据
     * @return the response entity
     */
    public static ResponseEntity ok(String msg, Object data) {
        return ResponseEntity.ok(new DataModel<>().ok(msg, data));
    }

    /**
     * 返回处理正确消息，返回处理结果的情况
     *
     * @param msg the msg  返回消息
     * @return the response entity
     */
    public static ResponseEntity ok(String msg) {
        return ResponseEntity.ok(new DataModel<>().ok(msg));
    }

    /**
     * 返回成功处理消息，需要返回数据的情况
     *
     * @param data the data 要返回的数据
     * @return the response entity
     */
    public static ResponseEntity ok(Object data) {
        return ResponseEntity.ok(new DataModel<>().ok(data, 1));
    }

    /**
     * @param data  要返回的数据
     * @param count 此次返回的数量
     * @return
     */
    public static ResponseEntity ok(Object data, int count) {
        return ResponseEntity.ok(new DataModel<>().ok(data, count));
    }

    /**
     * 返回失败消息
     *
     * @param code the code  业务系统错误代码
     * @param msg  the msg   错误消息
     * @return the response entity 默认返回 status:500错误
     */
    public static ResponseEntity fail(int code, String msg) {
        return ResponseEntity.status(500).body(new DataModel<>().fail(code, msg));
    }

    /**
     * 返回失败消息
     *
     * @param msg the msg
     * @return 返回http status 500
     */
    public static ResponseEntity fail(String msg) {
        return ResponseEntity.status(500).body(new DataModel<>().fail(500, msg));
    }

    public static ResponseEntity fail(String msg, Object data) {
        return ResponseEntity.status(500).body(new DataModel<>().fail(msg, data));
    }

    public static ResponseEntity fail(String msg, String error) {
        return ResponseEntity.status(500).body(new DataModel<>().fail(msg, error));
    }

    public static ResponseEntity fail(int code, String msg, Object data) {
        return ResponseEntity.status(500).body(new DataModel<>().fail(code, msg, data));
    }

    /**
     * 返回失败消息
     *
     * @param status the status
     * @param msg    the msg
     * @return the response entity
     */
    public static ResponseEntity fail(HttpStatus status, String msg) {
        return ResponseEntity.status(status).body(new DataModel<>().fail(status.value(), msg));
    }

    /**
     * @param msg 返回参数不正确的错误结果，status:400
     * @return
     */
    public static ResponseEntity badRequest(String msg) {
        return ResponseEntity.badRequest().body(new DataModel<>().fail(406, msg));
    }

    /**
     * 返回失败消息
     *
     * @param status the status httpstatus状态
     * @param code   the code   业务系统错误码
     * @param msg    the msg    错误消息
     * @return the response entity
     */
    public static ResponseEntity fail(HttpStatus status, int code, String msg) {
        return ResponseEntity.status(status).body(new DataModel<>().fail(code, msg));
    }

    /**
     * 返回失败消息
     *
     * @param status httpstatus状态
     * @param code   业务系统错误码
     * @param msg    错误消息
     * @param error  异常描述
     * @return the response entity
     */
    public static ResponseEntity fail(HttpStatus status, int code, String msg, String error) {
        return ResponseEntity.status(status).body(new DataModel<>().fail(code, msg, error));
    }
}
