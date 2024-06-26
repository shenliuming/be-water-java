package com.be.water.system.convert;

import com.be.water.system.entity.SysThirdLoginEntity;
import com.be.water.system.vo.SysThirdLoginVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 第三方登录
 *
 */
@Mapper
public interface SysThirdLoginConvert {
    SysThirdLoginConvert INSTANCE = Mappers.getMapper(SysThirdLoginConvert.class);

    SysThirdLoginEntity convert(SysThirdLoginVO vo);

    SysThirdLoginVO convert(SysThirdLoginEntity entity);

    List<SysThirdLoginVO> convertList(List<SysThirdLoginEntity> list);

}