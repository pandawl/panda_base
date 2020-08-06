package com.panda.pa.utils.model;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.panda.pa.utils.Constant;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.IntStream;

/**
 * 处理排序工具类
 */
@SuppressWarnings("unchecked")
public class SortUtil {
    /**
     * 处理排序（分页情况下） for mybatis-plus
     *
     * @param jqPager           QueryRequest
     * @param page              Page
     * @param defaultSort       默认排序的字段
     * @param defaultOrder      默认排序规则
     * @param camelToUnderscore 是否开启驼峰转下划线
     */
    public static void handlePageSort(JQPager jqPager, Page page, String defaultSort, String defaultOrder, boolean camelToUnderscore) {
        //设置当前页
        page.setCurrent(jqPager.getPage());
        //设置每页大小
        page.setSize(jqPager.getRows());
        String sortField = jqPager.getSidx();
        if (camelToUnderscore) {
            sortField = camelToUnderscore(sortField);
            defaultSort = camelToUnderscore(defaultSort);
        }
        if (StringUtils.isNotBlank(jqPager.getSidx())
                && StringUtils.isNotBlank(jqPager.getSord())
                && !StringUtils.equalsIgnoreCase(jqPager.getSidx(), "undefined")
                && !StringUtils.equalsIgnoreCase(jqPager.getSord(), "undefined")) {
            if (StringUtils.equals(jqPager.getSord(), Constant.ORDER_DESC))
                page.setDesc(sortField);
            else
                page.setAsc(sortField);
        } else {
            if (StringUtils.isNotBlank(defaultSort)) {
                if (StringUtils.equals(defaultOrder, Constant.ORDER_DESC))
                    page.setDesc(defaultSort);
                else
                    page.setAsc(defaultSort);
            }
        }
    }

    /**
     * 多字段排序
     * @param jqPager
     * @param page
     * @param orders
     * @param camelToUnderscore
     */
    public static void handlePageSort(JQPager jqPager, Page page, List<OrderItem> orders, boolean camelToUnderscore) {
        //设置当前页
        page.setCurrent(jqPager.getPage());
        //设置每页大小
        page.setSize(jqPager.getRows());
        String sortField = jqPager.getSidx();
        if (camelToUnderscore) {
            sortField = camelToUnderscore(sortField);

        }
        if (StringUtils.isNotBlank(jqPager.getSidx())
                && StringUtils.isNotBlank(jqPager.getSord())
                && !StringUtils.equalsIgnoreCase(jqPager.getSidx(), "undefined")
                && !StringUtils.equalsIgnoreCase(jqPager.getSord(), "undefined")) {
            if (StringUtils.equals(jqPager.getSord(), Constant.ORDER_DESC))
                page.setDesc(sortField);
            else
                page.setAsc(sortField);
        } else {

          if(null != orders && orders.size() > 0){
             page.setOrders(orders);
          }
        }
    }


    /**
     * 处理排序 for mybatis-plus
     *
     * @param jqPager QueryRequest
     * @param page    Page
     */
    public static void handlePageSort(JQPager jqPager, Page page) {
        handlePageSort(jqPager, page, null, null, false);
    }

    /**
     * 处理排序 for mybatis-plus
     *
     * @param jqPager           QueryRequest
     * @param page              Page
     * @param camelToUnderscore 是否开启驼峰转下划线
     */
    public static void handlePageSort(JQPager jqPager, Page page, boolean camelToUnderscore) {
        handlePageSort(jqPager, page, null, null, camelToUnderscore);
    }

    /**
     * 处理排序 for mybatis-plus
     *
     * @param jqPager           QueryRequest
     * @param wrapper           wrapper
     * @param defaultSort       默认排序的字段
     * @param defaultOrder      默认排序规则
     * @param camelToUnderscore 是否开启驼峰转下划线
     */
    public static void handleWrapperSort(JQPager jqPager, QueryWrapper wrapper, String defaultSort, String defaultOrder, boolean camelToUnderscore) {
        String sortField = jqPager.getSidx();
        if (camelToUnderscore) {
            sortField = camelToUnderscore(sortField);
            defaultSort = camelToUnderscore(defaultSort);
        }
        if (StringUtils.isNotBlank(jqPager.getSidx())
                && StringUtils.isNotBlank(jqPager.getSord())
                && !StringUtils.equalsIgnoreCase(jqPager.getSidx(), "undefined")
                && !StringUtils.equalsIgnoreCase(jqPager.getSord(), "undefined")) {
            if (StringUtils.equals(jqPager.getSord(), Constant.ORDER_DESC))
                wrapper.orderByDesc(sortField);
            else
                wrapper.orderByAsc(sortField);
        } else {
            if (StringUtils.isNotBlank(defaultSort)) {
                if (StringUtils.equals(defaultOrder, Constant.ORDER_DESC))
                    wrapper.orderByDesc(defaultSort);
                else
                    wrapper.orderByAsc(defaultSort);
            }
        }
    }

    /**
     * 处理排序 for mybatis-plus
     *
     * @param jqPager QueryRequest
     * @param wrapper wrapper
     */
    public static void handleWrapperSort(JQPager jqPager, QueryWrapper wrapper) {
        handleWrapperSort(jqPager, wrapper, null, null, false);
    }

    /**
     * 处理排序 for mybatis-plus
     *
     * @param jqPager           QueryRequest
     * @param wrapper           wrapper
     * @param camelToUnderscore 是否开启驼峰转下划线
     */
    public static void handleWrapperSort(JQPager jqPager, QueryWrapper wrapper, boolean camelToUnderscore) {
        handleWrapperSort(jqPager, wrapper, null, null, camelToUnderscore);
    }

    /**
     * 驼峰转下划线
     *
     * @param value 待转换值
     * @return 结果
     */
    public static String camelToUnderscore(String value) {
        if (StringUtils.isBlank(value))
            return value;
        String[] arr = StringUtils.splitByCharacterTypeCamelCase(value);
        if (arr.length == 0)
            return value;
        StringBuilder result = new StringBuilder();
        IntStream.range(0, arr.length).forEach(i -> {
            if (i != arr.length - 1)
                result.append(arr[i]).append("_");
            else
                result.append(arr[i]);
        });
        return StringUtils.lowerCase(result.toString());
    }
}
