package com.be.water.message.service;

import com.be.water.framework.common.utils.PageResult;
import com.be.water.framework.mybatis.service.BaseService;
import com.be.water.message.entity.SmsLogEntity;
import com.be.water.message.query.SmsLogQuery;
import com.be.water.message.vo.SmsLogVO;

/**
 * 短信日志
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://be-water.net">MAKU</a>
 */
public interface SmsLogService extends BaseService<SmsLogEntity> {

    PageResult<SmsLogVO> page(SmsLogQuery query);

}