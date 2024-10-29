package com.be.water.quartz.dao;

import com.be.water.framework.common.dao.BaseDao;
import com.be.water.quartz.entity.ScheduleJobEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 定时任务
*
* 
*/
@Mapper
public interface ScheduleJobDao extends BaseDao<ScheduleJobEntity> {
	
}