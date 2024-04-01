package com.be.water.system.convert;

import com.be.water.system.entity.SysLogOperateEntity;
import com.be.water.system.vo.SysLogOperateVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 操作日志
 *
 */
@Mapper
public interface SysLogOperateConvert {
    SysLogOperateConvert INSTANCE = Mappers.getMapper(SysLogOperateConvert.class);

    SysLogOperateEntity convert(SysLogOperateVO vo);

    SysLogOperateVO convert(SysLogOperateEntity entity);

    List<SysLogOperateVO> convertList(List<SysLogOperateEntity> list);

}