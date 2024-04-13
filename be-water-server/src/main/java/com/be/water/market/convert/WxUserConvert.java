package com.be.water.market.convert;


import com.be.water.market.entity.WxUserEntity;
import com.be.water.market.vo.WxUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 微信用户表
*
* @author shenliuming ceekayshen@foxmail.com
* @since 1.0.0 2024-04-14
*/
@Mapper
public interface WxUserConvert {
    WxUserConvert INSTANCE = Mappers.getMapper(WxUserConvert.class);

    WxUserEntity convert(WxUserVO vo);

    WxUserVO convert(WxUserEntity entity);

    List<WxUserVO> convertList(List<WxUserEntity> list);

}