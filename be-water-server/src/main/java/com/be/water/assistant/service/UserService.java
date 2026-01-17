package com.be.water.assistant.service;

import com.be.water.framework.common.page.PageResult;
import com.be.water.framework.common.service.BaseService;
import com.be.water.assistant.vo.UserVO;
import com.be.water.assistant.query.UserQuery;
import com.be.water.assistant.entity.UserEntity;

import java.util.List;

/**
 * 用户表
 *
 * @author shenliuming 597478495@qq.com
 * @since 1.0.0 2024-10-29
 */
public interface UserService extends BaseService<UserEntity> {

    PageResult<UserVO> page(UserQuery query);

    void save(UserVO vo);

    void update(UserVO vo);

    void delete(List<Long> idList);
}