package com.be.water.market.convert;

import com.be.water.market.entity.WxAccountConfigEntity;
import com.be.water.market.vo.WxAccountConfigVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* 存储微信公众号的基础配置信息
*
* @author shenliuming ceekayshen@foxmail.com
* @since 1.0.0 2024-04-13
*/
@Mapper
public interface WxAccountConfigConvert {
    WxAccountConfigConvert INSTANCE = Mappers.getMapper(WxAccountConfigConvert.class);

    WxAccountConfigEntity convert(WxAccountConfigVO vo);

    WxAccountConfigVO convert(WxAccountConfigEntity entity);

    List<WxAccountConfigVO> convertList(List<WxAccountConfigEntity> list);

}