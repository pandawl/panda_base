package com.panda.pa.utils.model;

public class JQPager {
    /**
     * 每页数据多少
     */
    private int rows;
    /**
     * 第几页
     */
    private int page;
    /**
     * 排序字段
     */
    private String sidx;
    /**
     * 排序方式 asc desc
     */
    private String sord;

    public int getRows() {
        if (0 >= this.rows) {
            return 10;
        }
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }
}
