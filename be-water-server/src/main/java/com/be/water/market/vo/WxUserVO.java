package com.be.water.market.vo;

import com.be.water.framework.common.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 微信用户表
*
* @author shenliuming ceekayshen@foxmail.com
* @since 1.0.0 2024-04-14
*/
@Data
@Schema(description = "微信用户表")
public class WxUserVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "主键ID")
	private Long id;

	@Schema(description = "微信openid")
	private String openId;

	@Schema(description = "appId")
	private String appId;

	@Schema(description = "appName")
	private String appName;

	@Schema(description = "手机号")
	private String phone;

	@Schema(description = "昵称")
	private String nickname;

	@Schema(description = "性别(0-未知、1-男、2-女)")
	private Integer sex;

	@Schema(description = "城市")
	private String city;

	@Schema(description = "省份")
	private String province;

	@Schema(description = "头像")
	private String avatar;

	@Schema(description = "订阅时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date subscribeTime;

	@Schema(description = "是否关注")
	private Integer subscribe;

	@Schema(description = "unionid")
	private String unionId;

	@Schema(description = "备注")
	private String remark;
	@Schema(description = "语言")
	private String language;

	@Schema(description = "标签ID列表")
	private String tagidList;

	@Schema(description = "关注场景")
	private String subscribeScene;

	@Schema(description = "扫码场景值")
	private String qrSceneStr;


}