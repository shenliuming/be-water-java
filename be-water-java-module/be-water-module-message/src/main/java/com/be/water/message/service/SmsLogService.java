package com.be.water.message.service;

import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.BaseService;
import com.be.water.message.entity.SmsLogEntity;
import com.be.water.message.query.SmsLogQuery;
import com.be.water.message.vo.SmsLogVO;

/**
 * 短信日志
 *
 */
public interface SmsLogService extends BaseService<SmsLogEntity> {

    PageResult<SmsLogVO> page(SmsLogQuery query);

}