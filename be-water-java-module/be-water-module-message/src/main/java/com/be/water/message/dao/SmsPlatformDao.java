package com.be.water.message.dao;

import com.be.water.framework.mybatis.dao.BaseDao;
import com.be.water.message.entity.SmsPlatformEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 短信平台
*
* @author 阿沐 babamu@126.com
*/
@Mapper
public interface SmsPlatformDao extends BaseDao<SmsPlatformEntity> {
	
}