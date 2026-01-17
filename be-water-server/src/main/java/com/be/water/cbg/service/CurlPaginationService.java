package com.be.water.cbg.service;

import com.be.water.cbg.core.model.YYSPageConfig;
import com.be.water.cbg.core.spi.HasMoreDecider;

import java.io.IOException;
import java.util.List;

/**
 * 提供对外的分页抓取服务接口
 */
public interface CurlPaginationService {

    /**
     * 根据curl命令执行分页抓取
     * @param curlCommand 原始curl字符串
     * @param config 分页配置（可为null，使用默认值）
     * @param decider 自定义是否继续的判定（可为null使用默认）
     * @return 每页的原始响应字符串列表
     */
    List<String> fetchAllPages(String curlCommand, YYSPageConfig config, HasMoreDecider decider)
            throws IOException, InterruptedException;

    /**
     * 直接获取指定ordersn的御魂详情（无分页）
     */
    String getEquipDesc(String serverId, String ordersn, String cookie) throws IOException;
}