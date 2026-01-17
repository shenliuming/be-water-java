package com.be.water.assistant.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.impl.BaseServiceImpl;
import com.be.water.assistant.convert.UserConvert;
import com.be.water.assistant.entity.UserEntity;
import com.be.water.assistant.query.UserQuery;
import com.be.water.assistant.vo.UserVO;
import com.be.water.assistant.dao.UserDao;
import com.be.water.assistant.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户表
 *
 * @author shenliuming 597478495@qq.com
 * @since 1.0.0 2024-10-29
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends BaseServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageResult<UserVO> page(UserQuery query) {
        IPage<UserEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(UserConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<UserEntity> getWrapper(UserQuery query){
        LambdaQueryWrapper<UserEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }

    @Override
    public void save(UserVO vo) {
        UserEntity entity = UserConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(UserVO vo) {
        UserEntity entity = UserConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}