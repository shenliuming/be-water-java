package com.github.be_water.common.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Date: 2024-03-19 16:42
 * @Author： shenliuming
 * @return：
 */
@Data
@Schema(description = "响应")
public class BaseDto<T> {

    @Schema(description = "跟踪ID，用于日志和调试")
    private String traceId;

    @Schema(description = "请求时间")
    private Long timestamp;

    @Schema(description = "响应数据")
    private T data;

    @Schema(description = "请求编码")
    private int code;

    @Schema(description = "响应信息")
    private String messge;

}
