package com.be.water.assistant.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.be.water.framework.common.query.Query;


/**
* 卡牌信息表查询
*
* @author shenliuming 597478495@qq.com
* @since 1.0.0 2024-10-29
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "卡牌信息表查询")
public class CardQuery extends Query {
}