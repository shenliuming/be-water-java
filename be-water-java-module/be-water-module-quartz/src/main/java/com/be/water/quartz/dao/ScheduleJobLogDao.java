package com.be.water.quartz.dao;

import com.be.water.framework.common.dao.BaseDao;
import com.be.water.quartz.entity.ScheduleJobLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 定时任务日志
*
* 
*/
@Mapper
public interface ScheduleJobLogDao extends BaseDao<ScheduleJobLogEntity> {
	
}