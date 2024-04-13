package com.be.water.market.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.be.water.framework.common.query.Query;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
* 微信用户表查询
*
* @author shenliuming ceekayshen@foxmail.com
* @since 1.0.0 2024-04-14
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "微信用户表查询")
public class WxUserQuery extends Query {
}