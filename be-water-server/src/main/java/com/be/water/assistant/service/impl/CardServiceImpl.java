package com.be.water.assistant.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.impl.BaseServiceImpl;
import com.be.water.assistant.convert.CardConvert;
import com.be.water.assistant.entity.CardEntity;
import com.be.water.assistant.query.CardQuery;
import com.be.water.assistant.vo.CardVO;
import com.be.water.assistant.dao.CardDao;
import com.be.water.assistant.service.CardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 卡牌信息表
 *
 * @author shenliuming 597478495@qq.com
 * @since 1.0.0 2024-10-29
 */
@Service
@AllArgsConstructor
public class CardServiceImpl extends BaseServiceImpl<CardDao, CardEntity> implements CardService {

    @Override
    public PageResult<CardVO> page(CardQuery query) {
        IPage<CardEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(CardConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<CardEntity> getWrapper(CardQuery query){
        LambdaQueryWrapper<CardEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }

    @Override
    public void save(CardVO vo) {
        CardEntity entity = CardConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(CardVO vo) {
        CardEntity entity = CardConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}