package com.be.water.cbg.service;

import net.ddm.framework.common.page.PageResult;
import net.ddm.framework.common.service.BaseService;
import net.ddm.ddm.vo.CbgAccountVO;
import net.ddm.ddm.query.CbgAccountQuery;
import net.ddm.ddm.entity.CbgAccountEntity;

import java.util.List;

/**
 * 藏宝阁阴阳师账号主表
 *
 * @author linghu ceekayshen@163.com
 * @since 1.0.0 2025-10-23
 */
public interface CbgAccountService extends BaseService<CbgAccountEntity> {

    PageResult<CbgAccountVO> page(CbgAccountQuery query);

    void save(CbgAccountVO vo);

    void update(CbgAccountVO vo);

    void delete(List<Long> idList);
}