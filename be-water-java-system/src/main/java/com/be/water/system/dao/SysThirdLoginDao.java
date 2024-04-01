package com.be.water.system.dao;

import com.be.water.framework.mybatis.dao.BaseDao;
import com.be.water.system.entity.SysThirdLoginEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 第三方登录
 *
 */
@Mapper
public interface SysThirdLoginDao extends BaseDao<SysThirdLoginEntity> {

}