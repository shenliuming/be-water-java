package com.be.water.market.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.be.water.market.convert.WxAccountConfigConvert;
import com.be.water.market.dao.WxAccountConfigDao;
import com.be.water.market.entity.WxAccountConfigEntity;
import com.be.water.market.query.WxAccountConfigQuery;
import com.be.water.market.service.WxAccountConfigService;
import com.be.water.market.vo.WxAccountConfigVO;
import lombok.AllArgsConstructor;
import com.be.water.framework.common.utils.PageResult;
import com.be.water.framework.mybatis.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 存储微信公众号的基础配置信息
 *
 * @author shenliuming ceekayshen@foxmail.com
 * @since 1.0.0 2024-04-13
 */
@Service
@AllArgsConstructor
public class WxAccountConfigServiceImpl extends BaseServiceImpl<WxAccountConfigDao, WxAccountConfigEntity> implements WxAccountConfigService {

    @Override
    public PageResult<WxAccountConfigVO> page(WxAccountConfigQuery query) {
        IPage<WxAccountConfigEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(WxAccountConfigConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<WxAccountConfigEntity> getWrapper(WxAccountConfigQuery query){
        LambdaQueryWrapper<WxAccountConfigEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(StringUtils.isEmpty(query.getAppId()),WxAccountConfigEntity::getAppId,query.getAppId());
        return wrapper;
    }

    @Override
    public void save(WxAccountConfigVO vo) {
        WxAccountConfigEntity entity = WxAccountConfigConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(WxAccountConfigVO vo) {
        WxAccountConfigEntity entity = WxAccountConfigConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    public WxAccountConfigVO getByAppId(String appId) {
        if(StringUtils.isEmpty(appId)){
            return null;
        }
        WxAccountConfigQuery query = new WxAccountConfigQuery();
        query.setAppId(appId);
        WxAccountConfigEntity entity = baseMapper.selectOne(getWrapper(query));

        return WxAccountConfigConvert.INSTANCE.convert(entity);
    }


}