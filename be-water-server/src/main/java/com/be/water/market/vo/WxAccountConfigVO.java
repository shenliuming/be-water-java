package com.be.water.market.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
* 存储微信公众号的基础配置信息
*
* @author shenliuming ceekayshen@foxmail.com
* @since 1.0.0 2024-04-13
*/
@Data
@Schema(description = "存储微信公众号的基础配置信息")
public class WxAccountConfigVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@Schema(description = "公众号appId")
	private String appId;

	@Schema(description = "公众号appName")
	private String appName;

	@Schema(description = "账号类型")
	private Integer type;

	@Schema(description = "appsecret")
	private String secret;

	@Schema(description = "token")
	private String token;

	@Schema(description = "aes_key")
	private String aesKey;

	@Schema(description = "是否流量分发: 1启用 0禁用")
	private Integer isFlowDist;

	@Schema(description = "状态: 1启用 0禁用")
	private Integer status;

	@Schema(description = "默认欢迎语")
	private String welcomeMessage;

	@Schema(description = "备注信息")
	private String remark;


}