package com.be.water.cbg.query;

import com.be.water.framework.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
* 藏宝阁阴阳师账号主表查询
*
* @author linghu ceekayshen@163.com
* @since 1.0.0 2025-10-23
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "藏宝阁阴阳师账号主表查询")
public class CbgAccountQuery extends Query {
}