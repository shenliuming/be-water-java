package com.be.water.cbg.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.ddm.framework.common.page.PageResult;
import net.ddm.framework.common.service.impl.BaseServiceImpl;
import net.ddm.ddm.convert.CbgAccountConvert;
import net.ddm.ddm.entity.CbgAccountEntity;
import net.ddm.ddm.query.CbgAccountQuery;
import net.ddm.ddm.vo.CbgAccountVO;
import net.ddm.ddm.dao.CbgAccountDao;
import net.ddm.ddm.service.CbgAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 藏宝阁阴阳师账号主表
 *
 * @author linghu ceekayshen@163.com
 * @since 1.0.0 2025-10-23
 */
@Service
@AllArgsConstructor
public class CbgAccountServiceImpl extends BaseServiceImpl<CbgAccountDao, CbgAccountEntity> implements CbgAccountService {

    @Override
    public PageResult<CbgAccountVO> page(CbgAccountQuery query) {
        IPage<CbgAccountEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(CbgAccountConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<CbgAccountEntity> getWrapper(CbgAccountQuery query){
        LambdaQueryWrapper<CbgAccountEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }

    @Override
    public void save(CbgAccountVO vo) {
        CbgAccountEntity entity = CbgAccountConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(CbgAccountVO vo) {
        CbgAccountEntity entity = CbgAccountConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}