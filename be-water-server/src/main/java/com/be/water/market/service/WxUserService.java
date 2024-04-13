package com.be.water.market.service;

import com.be.water.framework.common.utils.PageResult;
import com.be.water.framework.mybatis.service.BaseService;
import com.be.water.market.entity.WxUserEntity;
import com.be.water.market.query.WxUserQuery;
import com.be.water.market.vo.WxUserVO;

import java.util.List;

/**
 * 微信用户表
 *
 * @author shenliuming ceekayshen@foxmail.com
 * @since 1.0.0 2024-04-14
 */
public interface WxUserService extends BaseService<WxUserEntity> {

    PageResult<WxUserVO> page(WxUserQuery query);

    void save(WxUserVO vo);

    void update(WxUserVO vo);

    void delete(List<Long> idList);
}