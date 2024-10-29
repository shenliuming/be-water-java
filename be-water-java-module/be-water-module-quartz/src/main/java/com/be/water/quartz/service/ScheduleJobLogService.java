package com.be.water.quartz.service;

import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.BaseService;
import com.be.water.quartz.entity.ScheduleJobLogEntity;
import com.be.water.quartz.query.ScheduleJobLogQuery;
import com.be.water.quartz.vo.ScheduleJobLogVO;

/**
 * 定时任务日志
 *
 */
public interface ScheduleJobLogService extends BaseService<ScheduleJobLogEntity> {

    PageResult<ScheduleJobLogVO> page(ScheduleJobLogQuery query);

}