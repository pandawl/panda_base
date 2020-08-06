package com.panda.pa.utils.model;

import lombok.Data;

/**
 * json返回模型
 *
 * @param <T> the type parameter
 * @author :wl
 * @date 09.09.2018
 */
@Data
public class DataModel<T> {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -1137551930346799282L;
    /**
     * 从业务层面判断，本次操作是否成功
     */
    private boolean success = true;
    /**
     * 返回的消息
     */
    private String message = "";
    /**
     * 异常调试信息
     */
    private String error = "";
    /**
     * 系统自定义错误码
     */
    private int code = 200;
    /**
     *以下字段用来给前端列表返回分页结果数据
     */
    /**
     * 携带的数据，可以是单个对象，也可以是list map 等
     */
    private T rows = null;
    /**
     * 总数量
     */
    private int records;

    /**
     * 总页数
     */
    private int total;
    /**
     * 当前页码
     */
    private int page;

    /**
     * Instantiates a new Data model.
     */
    public DataModel() {
    }

    /**
     * 返回失败信息
     *
     * @param message the message
     * @return the data model
     */
    public DataModel fail(String message) {
        this.success = false;
        this.message = message;
        this.code = 500;
        return this;
    }

    public DataModel fail(String message, T data) {
        this.success = false;
        this.message = message;
        this.rows = data;
        this.code = 500;
        return this;
    }

    /**
     * 返回失败信息
     *
     * @param message 错误提示信息
     * @param error   程序错误
     * @return the data model
     */
    public DataModel fail(String message, String error) {
        this.success = false;
        this.message = message;
        this.error = error;
        this.code = 500;
        return this;
    }

    /**
     * 返回错误信息，带对象数据
     *
     * @param message 显示的错误消息
     * @param error   错误信息
     * @param data    携带的数据
     * @return
     */
    public DataModel fail(String message, String error, T data) {
        this.success = false;
        this.message = message;
        this.error = error;
        this.code = 500;
        this.rows = data;
        return this;
    }

    /**
     * 返回错误信息，带对象数据
     *
     * @param code    错误码
     * @param message 错误消息
     * @param error   错误
     * @param data    数据
     * @return
     */
    public DataModel fail(int code, String message, String error, T data) {
        this.success = false;
        this.message = message;
        this.error = error;
        this.code = code;
        this.rows = data;
        return this;
    }

    /**
     * 返回错误信息，带对象数据
     *
     * @param code    错误码
     * @param message 错误消息
     * @param data    数据
     * @return
     */
    public DataModel fail(int code, String message, T data) {
        this.success = false;
        this.message = message;
        this.code = code;
        this.rows = data;
        return this;
    }

    /**
     * Fail data model.
     *
     * @param code    错误码,默认200
     * @param message 错误提示信息
     * @param error   程序错误
     * @return the data model
     */
    public DataModel fail(int code, String message, String error) {
        this.success = false;
        this.code = code;
        this.message = message;
        this.error = error;
        return this;
    }

    public DataModel fail(int code, String message) {
        this.success = false;
        this.code = code;
        this.message = message;
        return this;
    }

    /**
     * 返回成功信息
     *
     * @param message the message
     * @return the data model
     */
    public DataModel ok(String message) {
        this.success = true;
        this.message = message;
        return this;
    }

    /**
     * 返回成功信息，带数据
     *
     * @param message the message
     * @param data    the data
     * @return the data model
     */
    public DataModel ok(String message, T data) {
        this.success = true;
        this.message = message;
        this.rows = data;
        return this;
    }

    public DataModel ok(T data, int totalCount, int page, int totalPage) {
        this.success = true;
        this.rows = data;
        this.total = totalPage;
        this.page = page;
        this.records = totalCount;
        return this;
    }

    public DataModel ok(T data, int count) {
        this.success = true;
        this.message = "处理成功";
        this.rows = data;
        this.total = count;
        return this;
    }

    /**
     * 成功返回数据
     *
     * @param data the data
     * @return the data model
     */
    public DataModel ok(T data) {
        this.success = true;
        this.message = "处理成功";
        this.rows = data;
        return this;
    }

    /**
     * Instantiates a new Data model.
     *
     * @param message the message
     */
    public DataModel(String message) {
        this.success = true;
        this.message = message;
    }

    /**
     * Instantiates a new Data model.
     *
     * @param message the message
     * @param data    the data
     */
    public DataModel(String message, T data) {
        this.message = message;
        this.success = true;
        this.rows = data;
    }

    /**
     * Instantiates a new Data model.
     *
     * @param success the success
     * @param message the message
     */
    public DataModel(boolean success, String message) {
        this.success = success;
        this.code = success ? 200 : 500;
        this.message = message;
    }

    /**
     * Instantiates a new Data model.
     *
     * @param data the data
     */
    public DataModel(T data) {
        this.success = true;
        this.rows = data;
    }
}
