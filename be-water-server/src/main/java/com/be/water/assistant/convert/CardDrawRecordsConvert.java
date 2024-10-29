package com.be.water.assistant.convert;

import com.be.water.assistant.entity.CardDrawRecordsEntity;
import com.be.water.assistant.vo.CardDrawRecordsVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 卡牌抽取记录
*
* @author shenliuming 597478495@qq.com
* @since 1.0.0 2024-10-29
*/
@Mapper
public interface CardDrawRecordsConvert {
    CardDrawRecordsConvert INSTANCE = Mappers.getMapper(CardDrawRecordsConvert.class);

    CardDrawRecordsEntity convert(CardDrawRecordsVO vo);

    CardDrawRecordsVO convert(CardDrawRecordsEntity entity);

    List<CardDrawRecordsVO> convertList(List<CardDrawRecordsEntity> list);

}