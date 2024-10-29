package com.be.water.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import com.be.water.framework.common.exception.ServerException;
import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.impl.BaseServiceImpl;
import com.be.water.system.convert.SysDictDataConvert;
import com.be.water.system.dao.SysDictDataDao;
import com.be.water.system.entity.SysDictDataEntity;
import com.be.water.system.query.SysDictDataQuery;
import com.be.water.system.service.SysDictDataService;
import com.be.water.system.vo.SysDictDataVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 数据字典
 *
 */
@Service
@AllArgsConstructor
public class SysDictDataServiceImpl extends BaseServiceImpl<SysDictDataDao, SysDictDataEntity> implements SysDictDataService {

    @Override
    public PageResult<SysDictDataVO> page(SysDictDataQuery query) {
        IPage<SysDictDataEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysDictDataConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private Wrapper<SysDictDataEntity> getWrapper(SysDictDataQuery query){
        LambdaQueryWrapper<SysDictDataEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysDictDataEntity::getDictTypeId, query.getDictTypeId());
        wrapper.orderByAsc(SysDictDataEntity::getSort);

        return wrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysDictDataVO vo) {
        SysDictDataEntity sysDictData = getOne(Wrappers.<SysDictDataEntity>lambdaQuery()
                .eq(SysDictDataEntity::getDictTypeId, vo.getDictTypeId())
                .eq(SysDictDataEntity::getDictValue, vo.getDictValue()));
        if (sysDictData != null) {
            throw new ServerException("字典值重复!");
        }

        SysDictDataEntity entity = SysDictDataConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysDictDataVO vo) {
        SysDictDataEntity sysDictData = getOne(Wrappers.<SysDictDataEntity>lambdaQuery()
                .eq(SysDictDataEntity::getDictTypeId, vo.getDictTypeId())
                .eq(SysDictDataEntity::getDictValue, vo.getDictValue())
                .ne(SysDictDataEntity::getId, vo.getId()));
        if (sysDictData != null) {
            throw new ServerException("字典值重复!");
        }

        SysDictDataEntity entity = SysDictDataConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }


}