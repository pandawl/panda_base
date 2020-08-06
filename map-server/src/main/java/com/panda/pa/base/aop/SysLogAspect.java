package com.panda.pa.base.aop;


import com.panda.pa.base.model.service.LogService;
import com.panda.pa.utils.web.HttpContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * 全局日志AOP实现
 *
 * @author :wl
 * @date 09.21.2019
 */
@Aspect
@Component
@Slf4j
public class SysLogAspect {

    /**
     * 日志服务
     */
    @Autowired
    LogService logService;

    /**
     * 切入点
     */
    @Pointcut("@annotation(com.panda.pa.base.aop.SysLog)")
    public void annotationPointCut() {
        log.debug("SysLogAspect in");
    }

    /**
     * around object.
     *
     * @param point the point
     * @return the object
     * @throws Throwable the throwable
     */
    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        SysLog asLog = method.getAnnotation(SysLog.class);
        String content = null;
        boolean saved = true;
        if (asLog != null) {
            content = asLog.content();
            saved = asLog.saved();
        }
        // 获取 request
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();

        if (null != request) {
            StringBuilder rparams = new StringBuilder(1000);
            Map map= request.getParameterMap();
            if (null != map) {
                int index = 0;
                Set<String> paramsStrs =map.keySet();
                if (null != paramsStrs) {
                    for (String param : paramsStrs) {
                        if(null!=param) {
                            rparams.append((index++ == 0 ? "" : "&") + param + "=");
                            rparams.append(request.getParameter(param));
                        }
                    }
                }
            }
        }
        if (saved) {
            //此处可以存储日志信息
            logService.log(request, content, true);
        }
       return  point.proceed();
    }

    @AfterReturning(returning = "rvt", pointcut = "annotationPointCut()")
    public Object afterExec(JoinPoint joinPoint, Object rvt) {
        return rvt;
    }

}
