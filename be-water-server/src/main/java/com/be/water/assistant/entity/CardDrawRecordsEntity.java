package com.be.water.assistant.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 卡牌抽取记录
 *
 * @author shenliuming 597478495@qq.com
 * @since 1.0.0 2024-10-29
 */

@Data
@TableName("t_card_draw_records")
public class CardDrawRecordsEntity {
	/**
	* id
	*/
	@TableId
	private Long id;

	/**
	* 用户id
	*/
	private Long userId;

	private Long heroId;

	/**
	* 获取时间
	*/
	private Date drawTime;

	private String cardId;

	private Integer starLevel;

	private String drawMethod;

	private String drawResult;

	/**
	* 创建时间
	*/
	private Date createTime;

}