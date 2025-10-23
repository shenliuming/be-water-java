package com.be.water.cbg.core.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 代表从 curl 解析出的请求规范
 */
public class YYSCurlRequest {
    private String url;
    private String method; // GET / POST
    private String contentType;
    private String cookie;
    private String bodyRaw;
    private Map<String, String> headers = new LinkedHashMap<String, String>();
    private Map<String, String> bodyParams = new LinkedHashMap<String, String>();

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    public String getContentType() { return contentType; }
    public void setContentType(String contentType) { this.contentType = contentType; }

    public String getCookie() { return cookie; }
    public void setCookie(String cookie) { this.cookie = cookie; }

    public String getBodyRaw() { return bodyRaw; }
    public void setBodyRaw(String bodyRaw) { this.bodyRaw = bodyRaw; }

    public Map<String, String> getHeaders() { return headers; }
    public void setHeaders(Map<String, String> headers) { this.headers = headers; }

    public Map<String, String> getBodyParams() { return bodyParams; }
    public void setBodyParams(Map<String, String> bodyParams) { this.bodyParams = bodyParams; }
}