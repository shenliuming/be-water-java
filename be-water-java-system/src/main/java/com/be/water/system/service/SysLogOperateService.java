package com.be.water.system.service;

import com.be.water.framework.common.utils.PageResult;
import com.be.water.framework.mybatis.service.BaseService;
import com.be.water.system.entity.SysLogOperateEntity;
import com.be.water.system.query.SysLogOperateQuery;
import com.be.water.system.vo.SysLogOperateVO;

/**
 * 操作日志
 *
 */
public interface SysLogOperateService extends BaseService<SysLogOperateEntity> {

    PageResult<SysLogOperateVO> page(SysLogOperateQuery query);
}