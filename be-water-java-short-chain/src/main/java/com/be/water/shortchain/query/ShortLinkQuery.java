package com.be.water.shortchain.query;

import com.be.water.framework.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 营销短链表查询
*
* @author shenliuming ceekayshen@foxmail.com
* @since 1.0.0 2024-04-05
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "营销短链表查询")
public class ShortLinkQuery extends Query {
}