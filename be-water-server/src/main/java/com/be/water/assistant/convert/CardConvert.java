package com.be.water.assistant.convert;

import com.be.water.assistant.entity.CardEntity;
import com.be.water.assistant.vo.CardVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 卡牌信息表
*
* @author shenliuming 597478495@qq.com
* @since 1.0.0 2024-10-29
*/
@Mapper
public interface CardConvert {
    CardConvert INSTANCE = Mappers.getMapper(CardConvert.class);

    CardEntity convert(CardVO vo);

    CardVO convert(CardEntity entity);

    List<CardVO> convertList(List<CardEntity> list);

}