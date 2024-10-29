package com.be.water.shortchain.service;

import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.BaseService;
import com.be.water.shortchain.vo.ShortLinkVO;
import com.be.water.shortchain.query.ShortLinkQuery;
import com.be.water.shortchain.entity.ShortLinkEntity;

import java.util.List;

/**
 * 营销短链表
 *
 * @author shenliuming ceekayshen@foxmail.com
 * @since 1.0.0 2024-04-05
 */
public interface ShortLinkService extends BaseService<ShortLinkEntity> {

    PageResult<ShortLinkVO> page(ShortLinkQuery query);

    void save(ShortLinkVO vo);

    void update(ShortLinkVO vo);

    void delete(List<Long> idList);
}