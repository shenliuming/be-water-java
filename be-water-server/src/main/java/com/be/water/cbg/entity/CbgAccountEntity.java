package com.be.water.cbg.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 藏宝阁阴阳师账号主表
 *
 * @author linghu ceekayshen@163.com
 * @since 1.0.0 2025-10-23
 */

@Data
@TableName("cbg_account")
public class CbgAccountEntity {
	/**
	* 主键
	*/
	@TableId
	private Long id;

	/**
	* 藏宝阁唯一装备编号
	*/
	private String eid;

	/**
	* 订单号
	*/
	private String gameOrdersn;

	/**
	* 服务器ID
	*/
	private Integer serverId;

	/**
	* 服务器名称
	*/
	private String serverName;

	/**
	* 平台类型 1=iOS 2=安卓
	*/
	private Integer platformType;

	/**
	* 大区名称
	*/
	private String areaName;

	/**
	* 账号等级
	*/
	private Integer equipLevel;

	/**
	* 售价（单位：元）
	*/
	private Integer price;

	/**
	* 0=未上架 1=公示期 2=在售 3=已售出
	*/
	private Integer status;

	/**
	* 是否允许还价 0=否 1=是
	*/
	private Integer allowBargain;

	/**
	* 收藏人数
	*/
	private Integer collectNum;

	/**
	* SSR 数量
	*/
	private Integer ssrNum;

	/**
	* 六星式神数量
	*/
	private Integer sixGodNum;

	/**
	* 连续签到天数
	*/
	private Integer signDays;

	/**
	* 散件一速
	*/
	private BigDecimal sanSpeed;

	/**
	* 招财一速
	*/
	private BigDecimal zhaoSpeed;

	/**
	* 头速（最快单件）
	*/
	private BigDecimal headSpeed;

	/**
	* 0 尾数量
	*/
	private Integer tail0;

	/**
	* 2 尾数量
	*/
	private Integer tail2;

	/**
	* 3 尾数量
	*/
	private Integer tail3;

	/**
	* 亮点标签 JSON 数组
	*/
	private Object highlights;

	/**
	* TOP5 式神 JSON
	*/
	private Object topHeros;

	/**
	* TOP5 皮肤 JSON
	*/
	private Object topSkins;

	/**
	* 自定义文案
	*/
	private String diyDesc;

	/**
	* 公示/在售结束时间
	*/
	private Date onsaleEndTime;

	/**
	* 寄售保护结束时间
	*/
	private Date onsaleProtectEnd;

	/**
	* 写入时间
	*/
	private Date createdAt;

	/**
	* 更新时间
	*/
	private Date updatedAt;

}