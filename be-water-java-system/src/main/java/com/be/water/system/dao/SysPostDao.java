package com.be.water.system.dao;

import com.be.water.framework.mybatis.dao.BaseDao;
import com.be.water.system.entity.SysPostEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 岗位管理
*
* @author 阿沐 babamu@126.com
*/
@Mapper
public interface SysPostDao extends BaseDao<SysPostEntity> {
	
}