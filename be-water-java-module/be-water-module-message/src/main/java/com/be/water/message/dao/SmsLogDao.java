package com.be.water.message.dao;

import com.be.water.framework.common.dao.BaseDao;
import com.be.water.message.entity.SmsLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 短信日志
*
* 
*/
@Mapper
public interface SmsLogDao extends BaseDao<SmsLogEntity> {
	
}