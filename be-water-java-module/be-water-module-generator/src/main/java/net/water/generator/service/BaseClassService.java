package net.water.generator.service;

import net.water.generator.common.page.PageResult;
import net.water.generator.common.query.Query;
import net.water.generator.common.service.BaseService;
import net.water.generator.entity.BaseClassEntity;

import java.util.List;

/**
 * 基类管理
 *

 */
public interface BaseClassService extends BaseService<BaseClassEntity> {

    PageResult<BaseClassEntity> page(Query query);

    List<BaseClassEntity> getList();
}