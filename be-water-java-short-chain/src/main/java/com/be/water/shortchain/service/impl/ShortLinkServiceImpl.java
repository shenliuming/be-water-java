package com.be.water.shortchain.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.impl.BaseServiceImpl;
import com.be.water.shortchain.convert.ShortLinkConvert;
import com.be.water.shortchain.entity.ShortLinkEntity;
import com.be.water.shortchain.query.ShortLinkQuery;
import com.be.water.shortchain.vo.ShortLinkVO;
import com.be.water.shortchain.dao.ShortLinkDao;
import com.be.water.shortchain.service.ShortLinkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 营销短链表
 *
 * @author shenliuming ceekayshen@foxmail.com
 * @since 1.0.0 2024-04-05
 */
@Service
@AllArgsConstructor
public class ShortLinkServiceImpl extends BaseServiceImpl<ShortLinkDao, ShortLinkEntity> implements ShortLinkService {

    @Override
    public PageResult<ShortLinkVO> page(ShortLinkQuery query) {
        IPage<ShortLinkEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(ShortLinkConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<ShortLinkEntity> getWrapper(ShortLinkQuery query){
        LambdaQueryWrapper<ShortLinkEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }

    @Override
    public void save(ShortLinkVO vo) {
        ShortLinkEntity entity = ShortLinkConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(ShortLinkVO vo) {
        ShortLinkEntity entity = ShortLinkConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}