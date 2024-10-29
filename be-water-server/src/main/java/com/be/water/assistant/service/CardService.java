package com.be.water.assistant.service;

import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.BaseService;
import com.be.water.assistant.vo.CardVO;
import com.be.water.assistant.query.CardQuery;
import com.be.water.assistant.entity.CardEntity;

import java.util.List;

/**
 * 卡牌信息表
 *
 * @author shenliuming 597478495@qq.com
 * @since 1.0.0 2024-10-29
 */
public interface CardService extends BaseService<CardEntity> {

    PageResult<CardVO> page(CardQuery query);

    void save(CardVO vo);

    void update(CardVO vo);

    void delete(List<Long> idList);
}