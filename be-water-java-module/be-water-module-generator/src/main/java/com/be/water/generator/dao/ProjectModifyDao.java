package com.be.water.generator.dao;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.be.water.generator.common.dao.BaseDao;
import com.be.water.generator.entity.ProjectModifyEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目名变更
 *

 */
@Mapper
@InterceptorIgnore(tenantLine = "true")
public interface ProjectModifyDao extends BaseDao<ProjectModifyEntity> {

}