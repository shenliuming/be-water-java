package com.be.water.market.dao;

import com.be.water.framework.common.dao.BaseDao;
import com.be.water.market.entity.WxAccountConfigEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 存储微信公众号的基础配置信息
*
* @author shenliuming ceekayshen@foxmail.com
* @since 1.0.0 2024-04-13
*/
@Mapper
public interface WxAccountConfigDao extends BaseDao<WxAccountConfigEntity> {
	
}