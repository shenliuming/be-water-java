package com.be.water.generator.service;

import com.be.water.generator.common.page.PageResult;
import com.be.water.generator.common.query.Query;
import com.be.water.generator.common.service.BaseService;
import com.be.water.generator.entity.BaseClassEntity;

import java.util.List;

/**
 * 基类管理
 *

 */
public interface BaseClassService extends BaseService<BaseClassEntity> {

    PageResult<BaseClassEntity> page(Query query);

    List<BaseClassEntity> getList();
}