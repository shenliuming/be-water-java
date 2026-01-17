package com.be.water.assistant.service;

import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.BaseService;
import com.be.water.assistant.vo.CardDrawRecordsVO;
import com.be.water.assistant.query.CardDrawRecordsQuery;
import com.be.water.assistant.entity.CardDrawRecordsEntity;

import java.util.List;

/**
 * 卡牌抽取记录
 *
 * @author shenliuming 597478495@qq.com
 * @since 1.0.0 2024-10-29
 */
public interface CardDrawRecordsService extends BaseService<CardDrawRecordsEntity> {

    PageResult<CardDrawRecordsVO> page(CardDrawRecordsQuery query);

    void save(CardDrawRecordsVO vo);

    void update(CardDrawRecordsVO vo);

    void delete(List<Long> idList);
}