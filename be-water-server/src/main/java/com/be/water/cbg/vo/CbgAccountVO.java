package com.be.water.cbg.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import net.ddm.framework.common.utils.DateUtils;
import java.math.BigDecimal;
import java.util.Date;

/**
* 藏宝阁阴阳师账号主表
*
* @author linghu ceekayshen@163.com
* @since 1.0.0 2025-10-23
*/
@Data
@Schema(description = "藏宝阁阴阳师账号主表")
public class CbgAccountVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "主键")
	private Long id;

	@Schema(description = "藏宝阁唯一装备编号")
	private String eid;

	@Schema(description = "订单号")
	private String gameOrdersn;

	@Schema(description = "服务器ID")
	private Integer serverId;

	@Schema(description = "服务器名称")
	private String serverName;

	@Schema(description = "平台类型 1=iOS 2=安卓")
	private Integer platformType;

	@Schema(description = "大区名称")
	private String areaName;

	@Schema(description = "账号等级")
	private Integer equipLevel;

	@Schema(description = "售价（单位：元）")
	private Integer price;

	@Schema(description = "0=未上架 1=公示期 2=在售 3=已售出")
	private Integer status;

	@Schema(description = "是否允许还价 0=否 1=是")
	private Integer allowBargain;

	@Schema(description = "收藏人数")
	private Integer collectNum;

	@Schema(description = "SSR 数量")
	private Integer ssrNum;

	@Schema(description = "六星式神数量")
	private Integer sixGodNum;

	@Schema(description = "连续签到天数")
	private Integer signDays;

	@Schema(description = "散件一速")
	private BigDecimal sanSpeed;

	@Schema(description = "招财一速")
	private BigDecimal zhaoSpeed;

	@Schema(description = "头速（最快单件）")
	private BigDecimal headSpeed;

	@Schema(description = "0 尾数量")
	private Integer tail0;

	@Schema(description = "2 尾数量")
	private Integer tail2;

	@Schema(description = "3 尾数量")
	private Integer tail3;

	@Schema(description = "亮点标签 JSON 数组")
	private Object highlights;

	@Schema(description = "TOP5 式神 JSON")
	private Object topHeros;

	@Schema(description = "TOP5 皮肤 JSON")
	private Object topSkins;

	@Schema(description = "自定义文案")
	private String diyDesc;

	@Schema(description = "公示/在售结束时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date onsaleEndTime;

	@Schema(description = "寄售保护结束时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date onsaleProtectEnd;

	@Schema(description = "写入时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createdAt;

	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date updatedAt;


}