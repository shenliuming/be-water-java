package com.be.water.market.service;

import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.BaseService;
import com.be.water.market.entity.WxAccountConfigEntity;
import com.be.water.market.query.WxAccountConfigQuery;
import com.be.water.market.vo.WxAccountConfigVO;

import java.util.List;

/**
 * 存储微信公众号的基础配置信息
 *
 * @author shenliuming ceekayshen@foxmail.com
 * @since 1.0.0 2024-04-13
 */
public interface WxAccountConfigService extends BaseService<WxAccountConfigEntity> {

    PageResult<WxAccountConfigVO> page(WxAccountConfigQuery query);

    void save(WxAccountConfigVO vo);

    void update(WxAccountConfigVO vo);

    void delete(List<Long> idList);

    WxAccountConfigVO getByAppId(String appId);
}