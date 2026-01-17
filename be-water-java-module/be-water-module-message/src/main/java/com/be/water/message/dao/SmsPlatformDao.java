package com.be.water.message.dao;

import com.be.water.framework.common.dao.BaseDao;
import com.be.water.message.entity.SmsPlatformEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 短信平台
*
* 
*/
@Mapper
public interface SmsPlatformDao extends BaseDao<SmsPlatformEntity> {
	
}