package com.be.water.cbg.service.impl;

import com.be.water.cbg.core.model.YYSPageConfig;
import com.be.water.cbg.core.model.YYSCurlRequest;
import com.be.water.cbg.core.parser.SimpleCurlParser;
import com.be.water.cbg.service.CurlPaginationService;
import com.be.water.cbg.core.spi.HasMoreDecider;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CurlPaginationServiceImpl implements CurlPaginationService {

    @Autowired
    private OkHttpClient httpClient;

    @Autowired
    private SimpleCurlParser parser;

    public List<String> fetchAllPages(String curlCommand, YYSPageConfig config, HasMoreDecider decider)
            throws IOException, InterruptedException {
        if (config == null) config = new YYSPageConfig();
        YYSCurlRequest spec = parser.parse(curlCommand);

        List<String> pages = new ArrayList<String>();
        int startPage = getIntParam(spec.getBodyParams(), config.getPageParamName(), 1);
        int pageSize = getIntParam(spec.getBodyParams(), config.getPageSizeParamName(), 15);

        int currentPage = startPage;
        for (int i = 0; i < config.getMaxPages(); i++) {
            String body = executeOnce(spec, config, currentPage, pageSize);
            pages.add(body);
            boolean goOn = (decider != null) ? decider.hasMore(body, i) : defaultHasMore(body, i);
            if (!goOn) break;
            currentPage++;
            try { Thread.sleep(config.getIntervalMillis()); } catch (InterruptedException ie) { throw ie; }
        }
        return pages;
    }

    public String getEquipDesc(String serverId, String ordersn, String cookie) throws IOException {
        String url = "https://yys.cbg.163.com/cgi/api/get_equip_desc?serverid=" + serverId +
                "&ordersn=" + ordersn + "&h5_device=other&app_client=other";
        Request.Builder rb = new Request.Builder();
        rb.url(url);
        rb.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
        rb.addHeader("Referer", "https://yys.cbg.163.com/");
        rb.addHeader("Accept", "application/json, text/plain, */*");
        if (cookie != null && cookie.length() > 0) rb.addHeader("Cookie", cookie);
        rb.get();
        Response resp = httpClient.newCall(rb.build()).execute();
        try {
            if (!resp.isSuccessful()) {
                return resp.body() != null ? resp.body().string() : ("HTTP_" + resp.code());
            }
            return resp.body() != null ? resp.body().string() : "";
        } finally {
            if (resp.body() != null) { resp.body().close(); }
        }
    }

    private boolean defaultHasMore(String responseBody, int pageIndex) {
        if (responseBody == null) return false;
        if (responseBody.contains("SESSION_TIMEOUT")) return false;
        if (responseBody.contains("\"list\":[]") || responseBody.contains("\"equip_list\":[]")) return false;
        return responseBody.length() > 10;
    }

    private String executeOnce(YYSCurlRequest spec, YYSPageConfig config, int page, int pageSize) throws IOException {
        Request.Builder rb = new Request.Builder();
        rb.url(spec.getUrl());
        // headers
        Map<String, String> headers = spec.getHeaders();
        if (headers != null) {
            java.util.Iterator<Map.Entry<String, String>> it = headers.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> e = it.next();
                rb.addHeader(e.getKey(), e.getValue());
            }
        }
        // cookie
        if (spec.getCookie() != null && spec.getCookie().length() > 0) rb.addHeader("Cookie", spec.getCookie());

        if ("POST".equalsIgnoreCase(spec.getMethod())) {
            String ct = spec.getContentType();
            if (ct == null) ct = "application/x-www-form-urlencoded; charset=UTF-8";
            MediaType mediaType = MediaType.parse(ct);
            String bodyString = rebuildFormBody(spec.getBodyParams(), spec.getBodyRaw(), config.getPageParamName(), config.getPageSizeParamName(), page, pageSize);
            RequestBody body = RequestBody.create(mediaType, bodyString == null ? "" : bodyString);
            rb.post(body);
        } else {
            String urlWithPage = buildGetUrlWithPagination(spec.getUrl(), config.getPageParamName(), config.getPageSizeParamName(), page, pageSize);
            rb.url(urlWithPage);
            rb.get();
        }
        Response resp = httpClient.newCall(rb.build()).execute();
        try {
            if (!resp.isSuccessful()) {
                return resp.body() != null ? resp.body().string() : ("HTTP_" + resp.code());
            }
            return resp.body() != null ? resp.body().string() : "";
        } finally {
            if (resp.body() != null) { resp.body().close(); }
        }
    }

    private String rebuildFormBody(Map<String, String> formParams,
                                   String raw,
                                   String pageParamName,
                                   String pageSizeParamName,
                                   int page,
                                   int pageSize) {
        if (formParams != null && !formParams.isEmpty()) {
            Map<String, String> copy = new LinkedHashMap<String, String>(formParams);
            copy.put(pageParamName, String.valueOf(page));
            copy.put(pageSizeParamName, String.valueOf(pageSize));
            StringBuilder sb = new StringBuilder();
            java.util.Iterator<Map.Entry<String, String>> it = copy.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> e = it.next();
                sb.append(e.getKey()).append("=").append(encode(e.getValue()));
                if (it.hasNext()) sb.append("&");
            }
            return sb.toString();
        }
        if (raw != null && raw.length() > 0) {
            String updated = replaceParam(raw, pageParamName, String.valueOf(page));
            updated = replaceParam(updated, pageSizeParamName, String.valueOf(pageSize));
            return updated;
        }
        return null;
    }

    private String buildGetUrlWithPagination(String url,
                                             String pageParamName,
                                             String pageSizeParamName,
                                             int page,
                                             int pageSize) {
        if (url == null) return null;
        int q = url.indexOf('?');
        if (q < 0) {
            String qs = pageParamName + "=" + encode(String.valueOf(page)) + "&" + pageSizeParamName + "=" + encode(String.valueOf(pageSize));
            return url + "?" + qs;
        }
        String base = url.substring(0, q);
        String query = url.substring(q + 1);
        String updated = replaceParam(query, pageParamName, String.valueOf(page));
        updated = replaceParam(updated, pageSizeParamName, String.valueOf(pageSize));
        if (updated.indexOf(pageParamName + "=") < 0) {
            updated = (updated.length() > 0 ? updated + "&" : updated) + pageParamName + "=" + encode(String.valueOf(page));
        }
        if (updated.indexOf(pageSizeParamName + "=") < 0) {
            updated = (updated.length() > 0 ? updated + "&" : updated) + pageSizeParamName + "=" + encode(String.valueOf(pageSize));
        }
        return base + "?" + updated;
    }

    private String replaceParam(String query, String key, String newValue) {
        String pattern = key + "=";
        int idx = query.indexOf(pattern);
        if (idx < 0) return query;
        int end = query.indexOf('&', idx);
        if (end < 0) end = query.length();
        return query.substring(0, idx + pattern.length()) + encode(newValue) + query.substring(end);
    }

    private String encode(String s) {
        try {
            return URLEncoder.encode(s == null ? "" : s, "UTF-8");
        } catch (Exception e) {
            return s;
        }
    }

    private int getIntParam(Map<String, String> params, String key, int def) {
        if (params == null) return def;
        String v = params.get(key);
        if (v == null) return def;
        try { return Integer.parseInt(v); } catch (Exception ignore) {}
        return def;
    }
}