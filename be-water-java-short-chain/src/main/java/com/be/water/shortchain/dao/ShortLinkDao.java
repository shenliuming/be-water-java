package com.be.water.shortchain.dao;

import com.be.water.framework.common.dao.BaseDao;
import com.be.water.shortchain.entity.ShortLinkEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 营销短链表
*
* @author shenliuming ceekayshen@foxmail.com
* @since 1.0.0 2024-04-05
*/
@Mapper
public interface ShortLinkDao extends BaseDao<ShortLinkEntity> {
	
}