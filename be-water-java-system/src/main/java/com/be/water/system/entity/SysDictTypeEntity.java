package com.be.water.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.be.water.framework.mybatis.entity.BaseEntity;

/**
 * 字典类型
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dict_type")
public class SysDictTypeEntity extends BaseEntity {
    /**
     * 字典类型
     */
    private String dictType;
    /**
     * 字典名称
     */
    private String dictName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 来源  0：字典数据  1：动态SQL
     */
    private Integer dictSource;
    /**
     * 动态sql
     */
    private String dictSql;
    /**
     * 租户ID
     */
    private Long tenantId;
}