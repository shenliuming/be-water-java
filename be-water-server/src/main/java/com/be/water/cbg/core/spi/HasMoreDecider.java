package com.be.water.cbg.core.spi;

/**
 * 分页继续判定接口
 */
public interface HasMoreDecider {
    boolean hasMore(String responseBody, int pageIndex);
}