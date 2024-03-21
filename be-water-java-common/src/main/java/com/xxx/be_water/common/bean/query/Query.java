package com.xxx.be_water.common.bean.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Date: 2024-03-21 17:24
 * @Author： shenliuming
 * @return：
 */
@Data
public class Query {

  @NotNull(message = "页码不能为空")
  @Min(value = 1, message = "页码最小值为 1")
  @Schema(description = "当前页码", required = true, defaultValue = "1")
  Integer page = 1;

  @NotNull(message = "每页条数不能为空")
  @Range(min = 1, max = 1000, message = "每页条数，取值范围 1-1000")
  @Schema(description = "每页条数", required = true, defaultValue = "10")
  Integer limit = 10;

  @Schema(description = "排序字段")
  String order;

  @Schema(description = "是否升序")
  boolean asc;

  @Schema(description = "开始时间")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  Date beginTime;

  @Schema(description = "结束时间")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  Date endTime;

  public <T> Page<T> buildPage() {
	return new Page<T>(this.page, this.limit);
  }

}
