package com.be.water.message.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import com.be.water.framework.common.constant.Constant;
import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.impl.BaseServiceImpl;
import com.be.water.message.cache.SmsPlatformCache;
import com.be.water.message.convert.SmsPlatformConvert;
import com.be.water.message.dao.SmsPlatformDao;
import com.be.water.message.entity.SmsPlatformEntity;
import com.be.water.message.query.SmsPlatformQuery;
import com.be.water.message.service.SmsPlatformService;
import com.be.water.message.sms.config.SmsConfig;
import com.be.water.message.vo.SmsPlatformVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 短信平台
 *
 */
@Service
@AllArgsConstructor
public class SmsPlatformServiceImpl extends BaseServiceImpl<SmsPlatformDao, SmsPlatformEntity> implements SmsPlatformService {
    private final SmsPlatformCache smsPlatformCache;

    @Override
    public PageResult<SmsPlatformVO> page(SmsPlatformQuery query) {
        IPage<SmsPlatformEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SmsPlatformConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<SmsPlatformEntity> getWrapper(SmsPlatformQuery query){
        LambdaQueryWrapper<SmsPlatformEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(query.getPlatform() != null, SmsPlatformEntity::getPlatform, query.getPlatform());
        wrapper.like(StrUtil.isNotBlank(query.getSignName()), SmsPlatformEntity::getSignName, query.getSignName());
        return wrapper;
    }

    @Override
    public List<SmsConfig> listByEnable() {
        // 从缓存读取
        List<SmsConfig> cacheList = smsPlatformCache.list();

        // 如果缓存没有，则从DB读取，然后保存到缓存里
        if(cacheList == null) {
            List<SmsPlatformEntity> list = this.list(new LambdaQueryWrapper<SmsPlatformEntity>().in(SmsPlatformEntity::getStatus, Constant.ENABLE));

            cacheList = SmsPlatformConvert.INSTANCE.convertList2(list);
            smsPlatformCache.save(cacheList);
        }

        return cacheList;
    }

    @Override
    public void save(SmsPlatformVO vo) {
        SmsPlatformEntity entity = SmsPlatformConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);

        smsPlatformCache.delete();
    }

    @Override
    public void update(SmsPlatformVO vo) {
        SmsPlatformEntity entity = SmsPlatformConvert.INSTANCE.convert(vo);

        updateById(entity);

        smsPlatformCache.delete();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

        smsPlatformCache.delete();
    }

}