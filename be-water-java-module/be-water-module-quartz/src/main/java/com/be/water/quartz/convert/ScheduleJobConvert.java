package com.be.water.quartz.convert;

import com.be.water.quartz.entity.ScheduleJobEntity;
import com.be.water.quartz.vo.ScheduleJobVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 定时任务
*
* 
*/
@Mapper
public interface ScheduleJobConvert {
    ScheduleJobConvert INSTANCE = Mappers.getMapper(ScheduleJobConvert.class);

    ScheduleJobEntity convert(ScheduleJobVO vo);

    ScheduleJobVO convert(ScheduleJobEntity entity);

    List<ScheduleJobVO> convertList(List<ScheduleJobEntity> list);

}