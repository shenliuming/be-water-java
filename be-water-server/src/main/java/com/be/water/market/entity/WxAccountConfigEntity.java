package com.be.water.market.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 存储微信公众号的基础配置信息
 *
 * @author shenliuming ceekayshen@foxmail.com
 * @since 1.0.0 2024-04-13
 */

@Data
@TableName("m_wx_account_config")
public class WxAccountConfigEntity {
	@TableId
	private Long id;

	/**
	* 公众号appId
	*/
	private String appId;

	/**
	* 公众号appName
	*/
	private String appName;

	/**
	* 账号类型
	*/
	private Integer type;

	/**
	* appsecret
	*/
	private String secret;

	/**
	* token
	*/
	private String token;

	/**
	* aes_key
	*/
	private String aesKey;

	/**
	* 是否流量分发: 1启用 0禁用
	*/
	private Integer isFlowDist;

	/**
	* 状态: 1启用 0禁用
	*/
	private Integer status;

	/**
	* 默认欢迎语
	*/
	private String welcomeMessage;

	/**
	* 备注信息
	*/
	private String remark;

}