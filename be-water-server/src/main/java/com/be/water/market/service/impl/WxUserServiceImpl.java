package com.be.water.market.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.impl.BaseServiceImpl;
import com.be.water.market.convert.WxUserConvert;
import com.be.water.market.dao.WxUserDao;
import com.be.water.market.entity.WxUserEntity;
import com.be.water.market.query.WxUserQuery;
import com.be.water.market.service.WxUserService;
import com.be.water.market.vo.WxUserVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 微信用户表
 *
 * @author shenliuming ceekayshen@foxmail.com
 * @since 1.0.0 2024-04-14
 */
@Service
@AllArgsConstructor
public class WxUserServiceImpl extends BaseServiceImpl<WxUserDao, WxUserEntity> implements WxUserService {

    @Override
    public PageResult<WxUserVO> page(WxUserQuery query) {
        IPage<WxUserEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(WxUserConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<WxUserEntity> getWrapper(WxUserQuery query){
        LambdaQueryWrapper<WxUserEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }

    @Override
    public void save(WxUserVO vo) {
        WxUserEntity entity = WxUserConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(WxUserVO vo) {
        WxUserEntity entity = WxUserConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}