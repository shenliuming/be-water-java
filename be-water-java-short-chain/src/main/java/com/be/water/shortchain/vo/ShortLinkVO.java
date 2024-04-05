package com.be.water.shortchain.vo;

import com.be.water.framework.common.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 营销短链表
*
* @author shenliuming ceekayshen@foxmail.com
* @since 1.0.0 2024-04-05
*/
@Data
@Schema(description = "营销短链表")
public class ShortLinkVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@Schema(description = "短链URL")
	private String shortUrl;

	@Schema(description = "原始URL")
	private String originalUrl;

	@Schema(description = "短链类型(1-课程,2-其他)")
	private Integer shortType;

	@Schema(description = "今日访问次数")
	private Integer pageViews;

	@Schema(description = "今日独立访客数")
	private Integer uniqueVisitors;

	@Schema(description = "今日获客次数")
	private Integer acquiredCustomers;

	@Schema(description = "累计访问次数")
	private Integer pvTotal;

	@Schema(description = "累计独立访客次数")
	private Integer uvTotal;

	@Schema(description = "累计获客次数")
	private Integer acTotal;

	@Schema(description = "状态 (0=禁用, 1=启用)")
	private Integer status;

	@Schema(description = "渠道ID")
	private Long channelId;

	@Schema(description = "渠道名称")
	private String channelName;

	@Schema(description = "网站域名ID")
	private Long domainId;

	@Schema(description = "网站域名名称")
	private String domainName;

	@Schema(description = "创建人ID")
	private String creatorId;

	@Schema(description = "创建人名称")
	private String creatorName;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTime;


}