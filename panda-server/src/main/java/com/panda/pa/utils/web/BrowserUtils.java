package com.panda.pa.utils.web;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Browser utils.
 *
 * @author :wl
 * @date 09.09.2018
 */
public class BrowserUtils {
    /**
     * 判断是否是IE
     *
     * @param request the request
     * @return boolean
     */
    public static boolean isIE(HttpServletRequest request) {
        return request.getHeader("USER-AGENT").toLowerCase().indexOf("Trident") > 0 || request.getHeader("USER-AGENT").toLowerCase().indexOf("msie") > 0 ? true : false;
    }

    /**
     * 获取IE版本
     *
     * @param request the request
     * @return i eversion
     */
    public static Double getIEversion(HttpServletRequest request) {
        Double version = 0.0;
        if (getBrowserType(request, "Trident 11.0")) {
            version = 11.0;
        }
        if (getBrowserType(request, "msie 10.0")) {
            version = 10.0;
        }
        if (getBrowserType(request, "msie 9.0")) {
            version = 9.0;
        }
        if (getBrowserType(request, "msie 8.0")) {
            version = 8.0;
        }
        if (getBrowserType(request, "msie 7.0")) {
            version = 7.0;
        }
        if (getBrowserType(request, "msie 6.0")) {
            version = 6.0;
        }
        return version;
    }

    /**
     * 获取浏览器类型
     *
     * @param request the request
     * @return browser type
     */
    public static BrowserType getBrowserType(HttpServletRequest request) {
        BrowserType browserType = null;
        if (getBrowserType(request, "msie 10.0")) {
            browserType = BrowserType.IE9;
        }
        if (getBrowserType(request, "msie 9.0")) {
            browserType = BrowserType.IE9;
        }
        if (getBrowserType(request, "msie 8.0")) {
            browserType = BrowserType.IE8;
        }
        if (getBrowserType(request, "msie 7.0")) {
            browserType = BrowserType.IE7;
        }
        if (getBrowserType(request, "msie 6.0")) {
            browserType = BrowserType.IE6;
        }
        if (getBrowserType(request, "Firefox")) {
            browserType = BrowserType.Firefox;
        }
        if (getBrowserType(request, "Safari")) {
            browserType = BrowserType.Safari;
        }
        if (getBrowserType(request, "Chrome")) {
            browserType = BrowserType.Chrome;
        }
        if (getBrowserType(request, "Opera")) {
            browserType = BrowserType.Opera;
        }
        if (getBrowserType(request, "Camino")) {
            browserType = BrowserType.Camino;
        }
        if (getBrowserType(request, "Trident")) {
            browserType = BrowserType.Trident;
        }
        return browserType;
    }

    /**
     * Gets browser type.
     *
     * @param request    the request
     * @param brosertype the brosertype
     * @return the browser type
     */
    private static boolean getBrowserType(HttpServletRequest request, String brosertype) {
        return request.getHeader("USER-AGENT").toLowerCase().indexOf(brosertype) > 0 ? true : false;
    }

    /**
     * The constant IE9.
     */
    private final static String IE9 = "MSIE 9.0";
    /**
     * The constant IE8.
     */
    private final static String IE8 = "MSIE 8.0";
    /**
     * The constant IE7.
     */
    private final static String IE7 = "MSIE 7.0";
    /**
     * The constant IE6.
     */
    private final static String IE6 = "MSIE 6.0";
    /**
     * The constant MAXTHON.
     */
    private final static String MAXTHON = "Maxthon";
    /**
     * The constant QQ.
     */
    private final static String QQ = "QQBrowser";
    /**
     * The constant GREEN.
     */
    private final static String GREEN = "GreenBrowser";
    /**
     * The constant SE360.
     */
    private final static String SE360 = "360SE";
    /**
     * The constant FIREFOX.
     */
    private final static String FIREFOX = "Firefox";
    /**
     * The constant OPERA.
     */
    private final static String OPERA = "Opera";
    /**
     * The constant CHROME.
     */
    private final static String CHROME = "Chrome";
    /**
     * The constant SAFARI.
     */
    private final static String SAFARI = "Safari";
    /**
     * The constant TRIDENT.
     */
    private final static String TRIDENT = "Trident";
    /**
     * The constant OTHER.
     */
    private final static String OTHER = "其它";
    /**
     * The constant MICROMESSAGE.
     */
    private final static String MICROMESSAGE = "MicroMessenger";

    /**
     * Check browse string.
     *
     * @param request the request
     * @return the string
     */
    public static String checkBrowse(HttpServletRequest request) {
        String userAgent = request.getHeader("USER-AGENT");
        if (regex(OPERA, userAgent)) {
            return OPERA;
        }
        if (regex(TRIDENT, userAgent)) {
            return TRIDENT;
        }
        if (regex(CHROME, userAgent)) {
            return CHROME;
        }
        if (regex(FIREFOX, userAgent)) {
            return FIREFOX;
        }
        if (regex(SAFARI, userAgent)) {
            return SAFARI;
        }
        if (regex(SE360, userAgent)) {
            return SE360;
        }
        if (regex(GREEN, userAgent)) {
            return GREEN;
        }
        if (regex(QQ, userAgent)) {
            return QQ;
        }
        if (regex(MAXTHON, userAgent)) {
            return MAXTHON;
        }
        if (regex(IE9, userAgent)) {
            return IE9;
        }
        if (regex(IE8, userAgent)) {
            return IE8;
        }
        if (regex(IE7, userAgent)) {
            return IE7;
        }
        if (regex(IE6, userAgent)) {
            return IE6;
        }
        if (regex(MICROMESSAGE, userAgent)) {
            return MICROMESSAGE;
        }
        return OTHER;
    }

    /**
     * Regex boolean.
     *
     * @param regex the regex
     * @param str   the str
     * @return the boolean
     */
    public static boolean regex(String regex, String str) {
        if (StringUtils.isBlank(regex) || StringUtils.isBlank(str)) {
            return false;
        }
        Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher m = p.matcher(str);
        return m.find();
    }

}
