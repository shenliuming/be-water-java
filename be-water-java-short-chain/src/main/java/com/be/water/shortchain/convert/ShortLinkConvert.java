package com.be.water.shortchain.convert;

import com.be.water.shortchain.entity.ShortLinkEntity;
import com.be.water.shortchain.vo.ShortLinkVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 营销短链表
*
* @author shenliuming ceekayshen@foxmail.com
* @since 1.0.0 2024-04-05
*/
@Mapper
public interface ShortLinkConvert {
    ShortLinkConvert INSTANCE = Mappers.getMapper(ShortLinkConvert.class);

    ShortLinkEntity convert(ShortLinkVO vo);

    ShortLinkVO convert(ShortLinkEntity entity);

    List<ShortLinkVO> convertList(List<ShortLinkEntity> list);

}