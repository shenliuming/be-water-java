package com.be.water.cbg.core.model;

/**
 * 分页配置，支持自定义参数名与限制
 */
public class YYSPageConfig {
    private String pageParamName = "page";
    private String pageSizeParamName = "count";
    private int maxPages = 50;
    private long intervalMillis = 1200L;

    public String getPageParamName() { return pageParamName; }
    public void setPageParamName(String pageParamName) { this.pageParamName = pageParamName; }

    public String getPageSizeParamName() { return pageSizeParamName; }
    public void setPageSizeParamName(String pageSizeParamName) { this.pageSizeParamName = pageSizeParamName; }

    public int getMaxPages() { return maxPages; }
    public void setMaxPages(int maxPages) { this.maxPages = maxPages; }

    public long getIntervalMillis() { return intervalMillis; }
    public void setIntervalMillis(long intervalMillis) { this.intervalMillis = intervalMillis; }
}