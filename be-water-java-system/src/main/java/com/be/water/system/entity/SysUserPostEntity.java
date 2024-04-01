package com.be.water.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.be.water.framework.mybatis.entity.BaseEntity;

/**
 * 用户岗位关系
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://be-water.net">MAKU</a>
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_user_post")
public class SysUserPostEntity extends BaseEntity {
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	* 岗位ID
	*/
	private Long postId;
}