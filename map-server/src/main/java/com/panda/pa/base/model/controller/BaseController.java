package com.panda.pa.base.model.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.panda.pa.utils.model.DataModel;
import com.panda.pa.utils.web.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器基类
 *
 * @author :wl
 * @date 09.09.2018
 */
@Slf4j
public abstract class BaseController {

    protected Map<String, Object> getDataTable(IPage<?> pageInfo) {
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", pageInfo.getRecords());
        rspData.put("total", pageInfo.getTotal());
        return rspData;
    }

    /**
     * 给JQGrid返回列表数据
     *
     * @param pageInfo  数据集合
     * @return response entity
     */
    public ResponseEntity jqGridOk(IPage<?> pageInfo) {
        return ResponseEntity.ok(new DataModel().ok(pageInfo.getRecords(), (int)pageInfo.getTotal(), (int)pageInfo.getCurrent(), (int)pageInfo.getPages()));
    }

    /**
     * 给JQGrid返回列表数据
     *
     * @param pageNo     当前页
     * @param pageSize   每页多少,不给就默认10
     * @param totalCount 总数多少
     * @param data       数据列表
     * @return response entity
     */
    public ResponseEntity jqGridOk(int pageNo, int pageSize, int totalCount, List<?> data) {
        int totalPage = (totalCount + pageSize - 1) / pageSize;
        return ResponseEntity.ok(new DataModel().ok(data, totalCount, pageNo, totalPage));
    }

    /**
     * 返回处理成功消息
     *
     * @return the response entity 返回默认成功消息
     */
    public ResponseEntity ok() {
        return ResponseUtils.ok();
    }

    /**
     * 返回处理正确消息(200)，返回处理结果的情况
     *
     * @param msg the msg  返回消息
     * @return the response entity
     */
    public ResponseEntity ok(String msg) {
        return ResponseUtils.ok(msg);
    }

    /**
     * 返回消息，携带数据
     *
     * @param msg  消息
     * @param data 数据
     * @return
     */
    public ResponseEntity ok(String msg, Object data) {
        return ResponseUtils.ok(msg, data);
    }
    /**
     * 返回列表数据
     *
     * @param data  列表数据
     * @param count 数量
     * @return
     */
    public ResponseEntity ok(Object data, int count) {
        return ResponseUtils.ok(data, count);
    }

    /**
     * 返回成功处理消息，需要返回数据的情况
     *
     * @param data the data 要返回的数据
     * @return the response entity
     */
    public ResponseEntity ok(Object data) {
        return ResponseUtils.ok(data);
    }


    /**
     * 返回500错误消息
     *
     * @param msg
     * @return
     */
    public ResponseEntity fail(String msg) {
        return ResponseUtils.fail(msg);
    }

    /**
     * 返回失败消息
     *
     * @param code the code  业务系统错误代码
     * @param msg  the msg   错误消息
     * @return the response entity 默认返回 status:500错误
     */
    public ResponseEntity fail(int code, String msg) {
        return ResponseUtils.fail(code, msg);
    }

    /**
     * 返回错误消息
     *
     * @param status 错误状态
     * @param msg    错误消息
     * @return
     */
    public ResponseEntity fail(HttpStatus status, String msg) {
        return ResponseUtils.fail(status, msg);
    }

    /**
     * 返回失败消息
     *
     * @param status the status httpstatus状态
     * @param code   the code   业务系统错误码
     * @param msg    the msg    错误消息
     * @return the response entity
     */
    public ResponseEntity fail(HttpStatus status, int code, String msg) {
        return ResponseUtils.fail(status, code, msg);
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
    public ResponseEntity fail(HttpStatus status, int code, String msg, String error) {
        return ResponseUtils.fail(status, code, msg, error);
    }

    /**
     * 返回错误消息，同时带数据
     *
     * @param msg  消息
     * @param data 数据
     * @return
     */
    public ResponseEntity fail(String msg, Object data) {
        return ResponseUtils.fail(msg, data);
    }


    /**
     * like 字符转义
     *
     * @param content
     * @return
     */
    public static String decodeSpecialCharsWhenLikeUseBackslash(String content) {
        if (StringUtils.isNotEmpty(content)) {
            // 单引号是字符串的边界,oralce中用2个单引号代表1个单引号
            String afterDecode = content.replaceAll("'", "''");
            // 由于使用了/作为ESCAPE的转义特殊字符,所以需要对该字符进行转义
            // 这里的作用是将"a/a"转成"a//a"
            afterDecode = afterDecode.replaceAll("/", "//");
            // 使用转义字符 /,对特殊字符% 进行转义,只作为普通查询字符，不是模糊匹配
            afterDecode = afterDecode.replaceAll("%", "/%");
            // 使用转义字符 /,对特殊字符_ 进行转义,只作为普通查询字符，不是模糊匹配
            afterDecode = afterDecode.replaceAll("_", "/_");
            return afterDecode;
        }
        return content;
    }

    /**
     * like 字符转义
     *
     * @param content
     * @return
     */
    public static String decodeSpecialCharsWhenLikeUseSlash(String content) {
        // 单引号是字符串的边界,oralce中用2个单引号代表1个单引号
        if (StringUtils.isNotEmpty(content)) {
            String afterDecode = content.replaceAll("'", "''");
            // 由于使用了\作为ESCAPE的转义特殊字符,所以需要对该字符进行转义
            // 由于\在java和正则表达式中都是特殊字符,需要进行特殊处理
            // 这里的作用是将"a\a"转成"a\\a"
            afterDecode = afterDecode.replaceAll("\\\\", "\\\\\\\\");
            // 使用转义字符 \,对特殊字符% 进行转义,只作为普通查询字符，不是模糊匹配
            afterDecode = afterDecode.replaceAll("%", "\\\\%");
            // 使用转义字符 \,对特殊字符_ 进行转义,只作为普通查询字符，不是模糊匹配
            afterDecode = afterDecode.replaceAll("_", "\\\\_");
            return afterDecode;
        }
        return content;
    }

}
