package com.panda.pa.base.model.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.panda.pa.base.model.entity.TSLog;
import com.panda.pa.base.model.mapper.LogMapper;
import com.panda.pa.base.model.service.LogService;
import com.panda.pa.utils.web.BrowserUtils;
import com.panda.pa.utils.web.RequestIpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: wl
 * @Date: 2020/2/26 12:52
 * @Description:
 */
@Slf4j
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, TSLog> implements LogService {

    @Override
    public void log(HttpServletRequest request, String logContent) {
        this.log(request, logContent, LOG_TYPE_SYS, false);
    }

    @Override
    public void log(HttpServletRequest request, String logContent, boolean save) {
        this.log(request, logContent, LOG_TYPE_SYS, save);
    }

    @Override
    public void log(HttpServletRequest request, String logContent, String logType) {
        this.log(request, logContent, LOG_TYPE_SYS, false);
    }

    @Override
    public void log(HttpServletRequest request, String logContent, String logType, boolean saved) {
        StringBuilder rparams = new StringBuilder(1000);
        int index = 0;
        if(null!=request){
            Map map=request.getParameterMap();
            if(map!=null){
                Set set= map.keySet();
                if(set!=null){
                    for (Object param : set) {
                        if (null!=param){
                            rparams.append((index++ == 0 ? "" : "&") + param + "=");
                            rparams.append(request.getParameter((String) param));
                        }
                    }
                }
            }
            String clientIp = RequestIpUtils.getIpAddr(request);
            log.info("日志:[{}],对端IP:[{}],请求参数是:[{}],请求内容:[{}]====",
                    logType, clientIp, rparams.toString(), logContent);
            if (saved) {
                TSLog log = new TSLog();
                log.setClientIp(clientIp);
                log.setRequestMethod(request.getMethod());
                log.setRequestTime(new Date());
                log.setRequestUri(request.getRequestURI());
                log.setUserAgent(request.getHeader("User-Agent"));
                log.setRequestParams(rparams.toString());
                log.setBrowserType(BrowserUtils.checkBrowse(request));
                log.setContent(logContent);
                log.setLogClass(logType);
                save(log);
            }

        }
    }

    @Override
    public void logPerm(HttpServletRequest request, String content, String userinfo) {
        if (null != request) {
            StringBuilder rparams = new StringBuilder(1000);
            int index = 0;
            Map map= request.getParameterMap();
            if (null!=map) {
                Set s= map.keySet();
                for (Object param : s) {
                    if (null!=param){
                        rparams.append((index++ == 0 ? "" : "&") + param + "=");
                        rparams.append(request.getParameter((String) param));
                    }
                }
            }
            String clientIp = RequestIpUtils.getIpAddr(request);
            TSLog log = new TSLog();
            log.setClientIp(clientIp);
            log.setRequestMethod(request.getMethod());
            log.setRequestTime(new Date());
            log.setRequestUri(request.getRequestURI());
            log.setUserAgent(request.getHeader("User-Agent"));
            log.setRequestParams(rparams.toString());
            log.setBrowserType(BrowserUtils.checkBrowse(request));
            log.setContent(content);
            log.setLogClass(LOG_TYPE_PERM);
            log.setUsername(userinfo);
            save(log);
        }
    }
}
