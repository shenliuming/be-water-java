package com.xxx.be_water.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Date: 2024-03-21 11:12
 * @Author： shenliuming
 * @return：
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {
  BAD_REQUEST(400, "Bad request or incomplete parameters"),
  UNAUTHORIZED(401, "Unauthorized or access token is invalid"),
  FORBIDDEN(403, "Access is forbidden, insufficient permissions"),
  NOT_FOUND(404, "Resource not found"),
  METHOD_NOT_ALLOWED(405, "Request method not supported"),
  CONFLICT(409, "Conflict, resource already exists"),
  PAYLOAD_TOO_LARGE(413, "Payload too large"),
  UNSUPPORTED_MEDIA_TYPE(415, "Unsupported media type"),
  RATE_LIMITED(429, "Too many requests, please try again later"),
  INTERNAL_SERVER_ERROR(500, "Internal server error, please try again later"),
  NOT_IMPLEMENTED(501, "Feature not implemented"),
  BAD_GATEWAY(502, "Bad gateway"),
  SERVICE_UNAVAILABLE(503, "Service unavailable, please try again later"),
  GATEWAY_TIMEOUT(504, "Gateway timeout");

  private final int code;
  private final String msg;
}