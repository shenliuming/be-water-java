package com.be.water.market.query;

import com.be.water.framework.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
* 存储微信公众号的基础配置信息查询
*
* @author shenliuming ceekayshen@foxmail.com
* @since 1.0.0 2024-04-13
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "存储微信公众号的基础配置信息查询")
public class WxAccountConfigQuery extends Query {

    private String appId;
}