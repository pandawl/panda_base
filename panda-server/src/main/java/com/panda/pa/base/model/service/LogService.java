package com.panda.pa.base.model.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.panda.pa.base.model.entity.TSLog;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: wl
 * @Date: 2020/2/26 12:44
 * @Description:
 */
public interface LogService extends IService<TSLog> {

    String LOG_TYPE_SYS = "SYS";
    String LOG_TYPE_BIZ = "BIZ";
    String LOG_TYPE_PERM = "PERM";

    /**
     * 记录访问日志(不入库)
     *
     * @param request    the request
     * @param logContent 日志内容
     */
    void log(HttpServletRequest request, String logContent);

    /**
     * 记录访问日志(入库可选)
     *
     * @param request    the request
     * @param logContent the log content
     * @param save       the save 是否入库？
     */
    void log(HttpServletRequest request, String logContent, boolean save);

    /**
     * 记录访问日志
     *
     * @param request    the request
     * @param logContent 日志内容
     * @param logType    日志类型
     */
    void log(HttpServletRequest request, String logContent, String logType);

    /**
     * 记录访问日志
     *
     * @param request    the request
     * @param logContent 日志内容
     * @param logType    日志类型
     * @param saved      是否保存到数据库？false则仅仅显示日志，true显示完毕保存到数据库
     */
    void log(HttpServletRequest request, String logContent, String logType, boolean saved);

    /**
     * 记录系统安全认证日志，比如token校验日志
     *
     * @param request  请求，不能为空
     * @param content  内容
     * @param userinfo 访问用户信息JSON
     */
    void logPerm(HttpServletRequest request, String content, String userinfo);
}
