package com.panda.pa.utils.data;


import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间工具类
 *
 * @author :wl
 * @date 09.28.2018
 */
public class MyDateUtils {
    private static Logger logger = LoggerFactory.getLogger(MyDateUtils.class);

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 计算时间差值
     * @param startTime ： 开始时间
     * @param endTime  ： 结束时间
     * @return
     */
    public static int caculateTotalTime(String startTime,String endTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date = null;
        Long l = 0L;
        try {
            date = formatter.parse(startTime);
            long ts = date.getTime();
            date1 = formatter.parse(endTime);
            long ts1 = date1.getTime();

            l = (ts - ts1) / (1000 * 60 * 60 * 24);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return l.intValue();

    }
    public static String formatFullTime(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(dateTimeFormatter);
    }
    /**
     * 获取现在时间
     *
     * @return 返回短时间字符串格式yyyy-MM-dd
     */
    public static String getStringDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String getStringDateLong() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     *
     * @param strDate
     * @return
     */
    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(strDate, pos);
    }

    /**
     * 获取当前年
     */
    public static String getNowYear(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        return formatter.format(new Date());
    }

    /**
     * 将短时间格式字符串转换为时间 yyyy-MM-dd
     *
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(strDate, pos);
    }

    /**
     *根据日期格式(yyyyMMdd)的日期获取下一天的日期(yyyy-MM-dd HH:mm:ss)
     */
    public static  String getNextDate(String day){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat formatterB = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date lastday=null;
        try {
            Date parse = formatter.parse(day);
            lastday = parse;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(lastday);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            lastday = calendar.getTime();
        } catch (ParseException e) {
            logger.info("error");
        }
        return  formatterB.format(lastday);
    }

    /**
     *根据日期格式(yyyyMMdd)的日期返回日期格式为(yyyy-MM-dd HH:mm:ss)
     */
    public static  String formatDate(String day){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat formatterB = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=null;
        try {
            Date parse = formatter.parse(day);
            date=formatterB.format(parse);
        } catch (ParseException e) {
            logger.info("error");
        }
        return  date;
    }

    /**
     * 获得指定日期的后一天
     *
     * @param specifiedDay
     * @return
     */
    public static String getDayAfter(String specifiedDay) throws ParseException {
        Calendar c = Calendar.getInstance();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }

    /**
     * 获取指定日期的前7天
     * @param specifiedDay
     * @return
     * @throws ParseException
     */
    public static String getDayWeek(String specifiedDay) throws ParseException {
        Calendar c = Calendar.getInstance();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day -7);
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }



    /**
     * 获得指定日期的前一天
     *
     * @param specifiedDay
     * @return
     */
    public static String getDayBefore(String specifiedDay) throws ParseException {
        Calendar c = Calendar.getInstance();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }

    /**
     * 获得指定日期的前一个月
     *
     * @param specifiedDay
     * @return
     */
    public static String getMonBefore(String specifiedDay) throws ParseException {
        Calendar c = Calendar.getInstance();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 30);
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }
    /**
     * 时间转为字符串 yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String getDataStringLong(Date date){
        if (null == date){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        return  dateStr;
    }

    /**
     * 时间转为字符串 yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String getStringLong(LocalDateTime date){
        if (null == date){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        return  dateStr;
    }

    /**
     * 时间转为字符串 yyyy-MM-dd
     * @param date
     * @return
     */
    public static String getDataStringShort(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(date);
        return  dateStr;
    }

    /**
     * 获得指定日期的前一个月的20号
     *
     * @param specifiedDay
     * @return
     */
    public static String getMonBefore20Day(String specifiedDay) throws ParseException {
        Calendar c = Calendar.getInstance();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 30);
        String dayAfter = new SimpleDateFormat("yyyy-MM-20").format(c.getTime());
        return dayAfter;
    }


    /**
     * 获取开始结束时间内每一天
     * @param dBegin1
     * @param dEnd1
     * @return
     */
    public static List<String> findDatess(String dBegin1, String dEnd1) {
        List<String> lDate = new ArrayList<>();
        Date dBegin = null;
        Date dEnd = null;
        try {
            dBegin = DateUtils.parseDate(dBegin1, "yyyy-MM-dd");
            dEnd = DateUtils.parseDate(dEnd1, "yyyy-MM-dd");
        } catch (ParseException e) {
            logger.info("error");
        }
        lDate.add(dBegin1);
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        while (dEnd.after(calBegin.getTime())) {
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(calBegin.getTime());
            lDate.add(dayAfter);
        }
        return lDate;
    }

    /*public static String[] stringTodate(String day){
        String[] s=new String[1024];
        if (day.length()==21){
            s = day.split("至");
        }
        return  s;
    }*/



}
