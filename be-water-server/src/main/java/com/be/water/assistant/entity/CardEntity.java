package com.be.water.assistant.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 卡牌信息表
 *
 * @author shenliuming 597478495@qq.com
 * @since 1.0.0 2024-10-29
 */

@Data
@TableName("t_card")
public class CardEntity {
	/**
	* 卡牌ID
	*/
	@TableId
	private Long id;

	/**
	* 卡牌名称
	*/
	private String name;

	/**
	* 卡牌图标链接
	*/
	private String icon;

	/**
	* 命中范围
	*/
	private Integer hitRange;

	/**
	* 英雄类型
	*/
	private Integer heroType;

	/**
	* 卡牌品质
	*/
	private Integer quality;

	/**
	* 费用
	*/
	private Integer cost;

	/**
	* 国家
	*/
	private Integer country;

	/**
	* 是否为赛季卡
	*/
	private Integer isSeasonCard;

	/**
	* 英雄等级
	*/
	private Integer heroLevel;

	/**
	* 政策觉醒状态
	*/
	private Integer policyAwakeState;

	/**
	* 觉醒状态
	*/
	private Integer awakeState;

	/**
	* 赛季
	*/
	private String season;

	/**
	* 进阶数量
	*/
	private Integer advanceNum;

	/**
	* 英雄类型进阶
	*/
	private Integer heroTypeAdvance;

	/**
	* 可用的英雄类型
	*/
	private Object cfgHeroTypeAvailible;

	/**
	* 可用的英雄类型
	*/
	private Object heroTypeAvailible;

	/**
	* 图标英雄ID
	*/
	private Long iconHeroId;

	/**
	* 英雄ID
	*/
	private Long heroId;

}