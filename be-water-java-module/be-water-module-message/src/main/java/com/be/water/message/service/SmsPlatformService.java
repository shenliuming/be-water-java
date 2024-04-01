package com.be.water.message.service;

import com.be.water.framework.common.utils.PageResult;
import com.be.water.framework.mybatis.service.BaseService;
import com.be.water.message.entity.SmsPlatformEntity;
import com.be.water.message.query.SmsPlatformQuery;
import com.be.water.message.sms.config.SmsConfig;
import com.be.water.message.vo.SmsPlatformVO;

import java.util.List;

/**
 * 短信平台
 *
 */
public interface SmsPlatformService extends BaseService<SmsPlatformEntity> {

    PageResult<SmsPlatformVO> page(SmsPlatformQuery query);

    /**
     * 启用的短信平台列表
     */
    List<SmsConfig> listByEnable();

    void save(SmsPlatformVO vo);

    void update(SmsPlatformVO vo);

    void delete(List<Long> idList);

}