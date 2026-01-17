package com.be.water.assistant.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import com.be.water.framework.common.utils.DateUtils;
import java.util.Date;

/**
* 卡牌抽取记录
*
* @author shenliuming 597478495@qq.com
* @since 1.0.0 2024-10-29
*/
@Data
@Schema(description = "卡牌抽取记录")
public class CardDrawRecordsVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "id")
	private Long id;

	@Schema(description = "用户id")
	private Long userId;

	private Long heroId;

	@Schema(description = "获取时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date drawTime;

	private String cardId;

	private Integer starLevel;

	private String drawMethod;

	private String drawResult;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTime;


}