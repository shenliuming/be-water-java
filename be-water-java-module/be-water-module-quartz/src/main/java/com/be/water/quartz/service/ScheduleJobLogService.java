package com.be.water.quartz.service;

import com.be.water.framework.common.utils.PageResult;
import com.be.water.framework.mybatis.service.BaseService;
import com.be.water.quartz.entity.ScheduleJobLogEntity;
import com.be.water.quartz.query.ScheduleJobLogQuery;
import com.be.water.quartz.vo.ScheduleJobLogVO;

/**
 * 定时任务日志
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://be-water.net">MAKU</a>
 */
public interface ScheduleJobLogService extends BaseService<ScheduleJobLogEntity> {

    PageResult<ScheduleJobLogVO> page(ScheduleJobLogQuery query);

}