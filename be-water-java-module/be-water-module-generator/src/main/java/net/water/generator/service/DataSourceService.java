package net.water.generator.service;

import net.water.generator.common.page.PageResult;
import net.water.generator.common.query.Query;
import net.water.generator.common.service.BaseService;
import net.water.generator.config.GenDataSource;
import net.water.generator.entity.DataSourceEntity;

import java.util.List;

/**
 * 数据源管理
 *

 */
public interface DataSourceService extends BaseService<DataSourceEntity> {

    PageResult<DataSourceEntity> page(Query query);

    List<DataSourceEntity> getList();

    /**
     * 获取数据库产品名，如：MySQL
     *
     * @param datasourceId 数据源ID
     * @return 返回产品名
     */
    String getDatabaseProductName(Long datasourceId);

    /**
     * 根据数据源ID，获取数据源
     *
     * @param datasourceId 数据源ID
     */
    GenDataSource get(Long datasourceId);
}