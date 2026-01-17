package com.be.water.cbg.convert;

import com.be.water.cbg.entity.CbgAccountEntity;
import com.be.water.cbg.vo.CbgAccountVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 藏宝阁阴阳师账号主表
*
* @author linghu ceekayshen@163.com
* @since 1.0.0 2025-10-23
*/
@Mapper
public interface CbgAccountConvert {
    CbgAccountConvert INSTANCE = Mappers.getMapper(CbgAccountConvert.class);

    CbgAccountEntity convert(CbgAccountVO vo);

    CbgAccountVO convert(CbgAccountEntity entity);

    List<CbgAccountVO> convertList(List<CbgAccountEntity> list);

}