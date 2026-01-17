package com.be.water.assistant.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 用户表
 *
 * @author shenliuming 597478495@qq.com
 * @since 1.0.0 2024-10-29
 */

@Data
@TableName("t_user")
public class UserEntity {
	/**
	* id
	*/
	@TableId
	private Long id;

	/**
	* 用户名
	*/
	private String username;

	/**
	* 密码
	*/
	private String password;

	/**
	* 姓名
	*/
	private String realName;

	/**
	* 头像
	*/
	private String avatar;

	/**
	* 性别   0：男   1：女   2：未知
	*/
	private Integer gender;

	/**
	* 邮箱
	*/
	private String email;

	/**
	* 手机号
	*/
	private String mobile;

	/**
	* 机构ID
	*/
	private Long orgId;

	/**
	* 超级管理员   0：否   1：是
	*/
	private Integer superAdmin;

	/**
	* 微信openId
	*/
	private String openId;

	/**
	* 状态  0：停用   1：正常
	*/
	private Integer status;

	/**
	* 版本号
	*/
	private Integer version;

	/**
	* 删除标识  0：正常   1：已删除
	*/
	private Integer deleted;

	/**
	* 创建者
	*/
	private Long creator;

	/**
	* 创建时间
	*/
	private Date createTime;

	/**
	* 更新者
	*/
	private Long updater;

	/**
	* 更新时间
	*/
	private Date updateTime;

}