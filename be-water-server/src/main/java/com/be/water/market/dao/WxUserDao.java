package com.be.water.market.dao;


import com.be.water.framework.mybatis.dao.BaseDao;
import com.be.water.market.entity.WxUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 微信用户表
*
* @author shenliuming ceekayshen@foxmail.com
* @since 1.0.0 2024-04-14
*/
@Mapper
public interface WxUserDao extends BaseDao<WxUserEntity> {
	
}