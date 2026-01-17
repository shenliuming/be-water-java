package com.be.water.system.service;

import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.BaseService;
import com.be.water.system.entity.SysDictDataEntity;
import com.be.water.system.query.SysDictDataQuery;
import com.be.water.system.vo.SysDictDataVO;

import java.util.List;

/**
 * 数据字典
 *
 */
public interface SysDictDataService extends BaseService<SysDictDataEntity> {

    PageResult<SysDictDataVO> page(SysDictDataQuery query);

    void save(SysDictDataVO vo);

    void update(SysDictDataVO vo);

    void delete(List<Long> idList);

}