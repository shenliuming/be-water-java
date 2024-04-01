package com.be.water.message.dao;

import com.be.water.framework.mybatis.dao.BaseDao;
import com.be.water.message.entity.SmsLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 短信日志
*
* @author 阿沐 babamu@126.com
*/
@Mapper
public interface SmsLogDao extends BaseDao<SmsLogEntity> {
	
}