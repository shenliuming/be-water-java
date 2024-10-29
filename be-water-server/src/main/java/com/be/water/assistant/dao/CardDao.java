package com.be.water.assistant.dao;

import com.be.water.framework.common.dao.BaseDao;
import com.be.water.assistant.entity.CardEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 卡牌信息表
*
* @author shenliuming 597478495@qq.com
* @since 1.0.0 2024-10-29
*/
@Mapper
public interface CardDao extends BaseDao<CardEntity> {
	
}