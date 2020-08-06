package com.panda.pa.base.aop;

import java.lang.annotation.*;

/**
 * 全局访问日志记录
 * 如果需要记录简单的系统访问日志，在需要记录的方法上添加@SysLog
 * 如果需要对处理结果进行详细记录，在方法内调用BaseServie中记录日志的方法实现。
 * content:日志内容，默认空
 * saved:是否保存到数据库,默认true
 *
 * @author :wl
 * @date 09.21.2019
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    /**
     * 日志内容
     *
     * @return the string
     */
    String content() default "";

    /**
     * 是否保存到数据库
     *
     * @return boolean
     */
    boolean saved() default true;
}
