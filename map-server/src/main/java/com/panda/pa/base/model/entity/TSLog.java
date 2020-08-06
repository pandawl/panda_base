package com.panda.pa.base.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志
 *
 * @author :wl
 * @date 09.21.2019
 */

@TableName("sys_log")
@Data
public class TSLog implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String userAgent;

    private String requestUri;

    private String requestParams;

    private String logClass;

    private String requestMethod;

    private String clientIp;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date requestTime;

    private String browserType;

    private String content;

    private String username;

}
