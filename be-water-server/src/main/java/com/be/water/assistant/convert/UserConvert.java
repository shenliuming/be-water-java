package com.be.water.assistant.convert;

import com.be.water.assistant.entity.UserEntity;
import com.be.water.assistant.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 用户表
*
* @author shenliuming 597478495@qq.com
* @since 1.0.0 2024-10-29
*/
@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserEntity convert(UserVO vo);

    UserVO convert(UserEntity entity);

    List<UserVO> convertList(List<UserEntity> list);

}