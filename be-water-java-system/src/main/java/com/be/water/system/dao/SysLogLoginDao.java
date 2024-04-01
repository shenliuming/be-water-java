package com.be.water.system.dao;

import com.be.water.framework.mybatis.dao.BaseDao;
import com.be.water.system.entity.SysLogLoginEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 登录日志
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://be-water.net">MAKU</a>
 */
@Mapper
public interface SysLogLoginDao extends BaseDao<SysLogLoginEntity> {

}