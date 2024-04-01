package com.xxx.be_water.common.bean.result;

import com.xxx.be_water.common.constant.ErrorCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @Date: 2024-03-19 23:47
 * @Author： shenliuming
 * @return：
 */
@Data
@Schema(description = "响应实体")
public class BaseResult<T> implements Serializable {

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

  public static <T> BaseResult<T> ok(){return ok(null);}
  public static <T> BaseResult<T> ok(T data){
	BaseResult<T> result = new BaseResult<>();
	result.setData(data);
	return ok();
  }
  public static <T> BaseResult<T> error() {
	return error(ErrorCode.INTERNAL_SERVER_ERROR);
  }

  public static <T> BaseResult<T> error(String msg) {
	return error(ErrorCode.INTERNAL_SERVER_ERROR.getCode(), msg);
  }

  public static <T> BaseResult<T> error(ErrorCode errorCode) {
	return error(errorCode.getCode(), errorCode.getMsg());
  }

  public static <T> BaseResult<T> error(int code, String msg) {
	BaseResult<T> result = new BaseResult<>();
	result.setCode(code);
	result.setMessge(msg);
	return result;
  }

}
