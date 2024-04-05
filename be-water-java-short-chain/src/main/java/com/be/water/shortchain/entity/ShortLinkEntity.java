package com.be.water.shortchain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.be.water.framework.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 营销短链表
 *
 * @author shenliuming ceekayshen@foxmail.com
 * @since 1.0.0 2024-04-05
 */
@EqualsAndHashCode(callSuper=false)
@Data
@TableName("m_short_links")
public class ShortLinkEntity extends BaseEntity {

	/**
	* 短链URL
	*/
	private String shortUrl;

	/**
	* 原始URL
	*/
	private String originalUrl;

	/**
	* 短链类型(1-课程,2-其他)
	*/
	private Integer shortType;

	/**
	* 今日访问次数
	*/
	private Integer pageViews;

	/**
	* 今日独立访客数
	*/
	private Integer uniqueVisitors;

	/**
	* 今日获客次数
	*/
	private Integer acquiredCustomers;

	/**
	* 累计访问次数
	*/
	private Integer pvTotal;

	/**
	* 累计独立访客次数
	*/
	private Integer uvTotal;

	/**
	* 累计获客次数
	*/
	private Integer acTotal;

	/**
	* 状态 (0=禁用, 1=启用)
	*/
	private Integer status;

	/**
	* 渠道ID
	*/
	private Long channelId;

	/**
	* 渠道名称
	*/
	private String channelName;

	/**
	* 网站域名ID
	*/
	private Long domainId;

	/**
	* 网站域名名称
	*/
	private String domainName;

	/**
	* 创建人ID
	*/
	private String creatorId;

	/**
	* 创建人名称
	*/
	private String creatorName;


}