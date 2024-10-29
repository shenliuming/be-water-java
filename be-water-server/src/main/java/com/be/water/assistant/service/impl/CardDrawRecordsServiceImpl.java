package com.be.water.assistant.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.impl.BaseServiceImpl;
import com.be.water.assistant.convert.CardDrawRecordsConvert;
import com.be.water.assistant.entity.CardDrawRecordsEntity;
import com.be.water.assistant.query.CardDrawRecordsQuery;
import com.be.water.assistant.vo.CardDrawRecordsVO;
import com.be.water.assistant.dao.CardDrawRecordsDao;
import com.be.water.assistant.service.CardDrawRecordsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 卡牌抽取记录
 *
 * @author shenliuming 597478495@qq.com
 * @since 1.0.0 2024-10-29
 */
@Service
@AllArgsConstructor
public class CardDrawRecordsServiceImpl extends BaseServiceImpl<CardDrawRecordsDao, CardDrawRecordsEntity> implements CardDrawRecordsService {

    @Override
    public PageResult<CardDrawRecordsVO> page(CardDrawRecordsQuery query) {
        IPage<CardDrawRecordsEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(CardDrawRecordsConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<CardDrawRecordsEntity> getWrapper(CardDrawRecordsQuery query){
        LambdaQueryWrapper<CardDrawRecordsEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }

    @Override
    public void save(CardDrawRecordsVO vo) {
        CardDrawRecordsEntity entity = CardDrawRecordsConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(CardDrawRecordsVO vo) {
        CardDrawRecordsEntity entity = CardDrawRecordsConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}