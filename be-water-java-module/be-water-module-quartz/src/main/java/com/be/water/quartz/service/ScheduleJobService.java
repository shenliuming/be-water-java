package com.be.water.quartz.service;

import com.be.water.framework.common.utils.PageResult;
import com.be.water.framework.mybatis.service.BaseService;
import com.be.water.quartz.entity.ScheduleJobEntity;
import com.be.water.quartz.query.ScheduleJobQuery;
import com.be.water.quartz.vo.ScheduleJobVO;

import java.util.List;

/**
 * 定时任务
 *
 */
public interface ScheduleJobService extends BaseService<ScheduleJobEntity> {

    PageResult<ScheduleJobVO> page(ScheduleJobQuery query);

    void save(ScheduleJobVO vo);

    void update(ScheduleJobVO vo);

    void delete(List<Long> idList);

    void run(ScheduleJobVO vo);

    void changeStatus(ScheduleJobVO vo);
}