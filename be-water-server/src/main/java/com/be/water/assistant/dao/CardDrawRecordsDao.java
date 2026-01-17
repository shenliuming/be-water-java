package com.be.water.assistant.dao;

import com.be.water.framework.common.dao.BaseDao;
import com.be.water.assistant.entity.CardDrawRecordsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 卡牌抽取记录
*
* @author shenliuming 597478495@qq.com
* @since 1.0.0 2024-10-29
*/
@Mapper
public interface CardDrawRecordsDao extends BaseDao<CardDrawRecordsEntity> {
	
}