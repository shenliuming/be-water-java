package com.be.water.market.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 微信用户表
 *
 * @author shenliuming ceekayshen@foxmail.com
 * @since 1.0.0 2024-04-14
 */

@Data
@TableName("m_wx_user")
public class WxUserEntity {
	/**
	* 主键ID
	*/
	@TableId
	private Long id;

	/**
	* 微信openid
	*/
	private String openId;

	/**
	* appId
	*/
	private String appId;

	/**
	* appName
	*/
	private String appName;

	/**
	* 手机号
	*/
	private String phone;

	/**
	* 昵称
	*/
	private String nickname;

	/**
	* 性别(0-未知、1-男、2-女)
	*/
	private Integer sex;

	/**
	* 城市
	*/
	private String city;

	/**
	* 省份
	*/
	private String province;

	/**
	* 头像
	*/
	private String avatar;

	/**
	* 订阅时间
	*/
	private Date subscribeTime;

	/**
	* 是否关注
	*/
	private Integer subscribe;

	/**
	* unionid
	*/
	private String unionId;

	/**
	 * unionid
	 */
	private String language;

	/**
	* 备注
	*/
	private String remark;

	/**
	* 标签ID列表
	*/
	private String tagidList;

	/**
	* 关注场景
	*/
	private String subscribeScene;

	/**
	* 扫码场景值
	*/
	private String qrSceneStr;

}