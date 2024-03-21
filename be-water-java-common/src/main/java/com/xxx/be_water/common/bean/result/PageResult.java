package com.xxx.be_water.common.bean.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Date: 2024-03-19 23:40
 * @Author： shenliuming
 * @return：
 */
@Data
@Schema(description = "响应实体")
public class PageResult<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  @Schema(description = "总记录数")
  private int total;

  @Schema(description = "列表数据")
  private List<T> list;

}
