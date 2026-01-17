package com.be.water.assistant.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.be.water.framework.common.query.Query;

import java.util.Date;

/**
* 卡牌抽取记录查询
*
* @author shenliuming 597478495@qq.com
* @since 1.0.0 2024-10-29
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "卡牌抽取记录查询")
public class CardDrawRecordsQuery extends Query {
}