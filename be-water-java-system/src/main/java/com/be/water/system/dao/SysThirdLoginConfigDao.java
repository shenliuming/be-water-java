package com.be.water.system.dao;

import com.be.water.framework.mybatis.dao.BaseDao;
import com.be.water.system.entity.SysThirdLoginConfigEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 第三方登录配置
 *
 */
@Mapper
public interface SysThirdLoginConfigDao extends BaseDao<SysThirdLoginConfigEntity> {

}