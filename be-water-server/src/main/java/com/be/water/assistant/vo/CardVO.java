package com.be.water.assistant.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import com.be.water.framework.common.utils.DateUtils;

/**
* 卡牌信息表
*
* @author shenliuming 597478495@qq.com
* @since 1.0.0 2024-10-29
*/
@Data
@Schema(description = "卡牌信息表")
public class CardVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "卡牌ID")
	private Long id;

	@Schema(description = "卡牌名称")
	private String name;

	@Schema(description = "卡牌图标链接")
	private String icon;

	@Schema(description = "命中范围")
	private Integer hitRange;

	@Schema(description = "英雄类型")
	private Integer heroType;

	@Schema(description = "卡牌品质")
	private Integer quality;

	@Schema(description = "费用")
	private Integer cost;

	@Schema(description = "国家")
	private Integer country;

	@Schema(description = "是否为赛季卡")
	private Integer isSeasonCard;

	@Schema(description = "英雄等级")
	private Integer heroLevel;

	@Schema(description = "政策觉醒状态")
	private Integer policyAwakeState;

	@Schema(description = "觉醒状态")
	private Integer awakeState;

	@Schema(description = "赛季")
	private String season;

	@Schema(description = "进阶数量")
	private Integer advanceNum;

	@Schema(description = "英雄类型进阶")
	private Integer heroTypeAdvance;

	@Schema(description = "可用的英雄类型")
	private Object cfgHeroTypeAvailible;

	@Schema(description = "可用的英雄类型")
	private Object heroTypeAvailible;

	@Schema(description = "图标英雄ID")
	private Long iconHeroId;

	@Schema(description = "英雄ID")
	private Long heroId;


}