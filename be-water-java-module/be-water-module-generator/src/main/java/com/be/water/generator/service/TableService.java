package com.be.water.generator.service;

import com.be.water.generator.common.page.PageResult;
import com.be.water.generator.common.query.Query;
import com.be.water.generator.common.service.BaseService;
import com.be.water.generator.entity.TableEntity;

/**
 * 数据表
 *

 */
public interface TableService extends BaseService<TableEntity> {

    PageResult<TableEntity> page(Query query);

    TableEntity getByTableName(String tableName);

    void deleteBatchIds(Long[] ids);

    /**
     * 导入表
     *
     * @param datasourceId 数据源ID
     * @param tableName    表名
     */
    void tableImport(Long datasourceId, String tableName);

    /**
     * 同步数据库表
     *
     * @param id 表ID
     */
    void sync(Long id);
}