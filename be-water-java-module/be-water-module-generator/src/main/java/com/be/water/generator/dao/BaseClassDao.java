package com.be.water.generator.dao;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.be.water.generator.entity.BaseClassEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 基类管理
 *

 */
@Mapper
@InterceptorIgnore(tenantLine = "true")
public interface BaseClassDao extends BaseMapper<BaseClassEntity> {

}