package com.be.water.cbg.core.parser;

import com.be.water.cbg.core.model.YYSCurlRequest;
import org.springframework.stereotype.Component;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Spring管理的curl解析组件
 */
@Component
public class SimpleCurlParser {

    public YYSCurlRequest parse(String curl) {
        YYSCurlRequest result = new YYSCurlRequest();
        // URL
        String url = extractByRegex(curl, "curl\\s+'([^']+)'", 1);
        if (url == null) {
            url = extractByRegex(curl, "curl\\s+\"([^\"]+)\"", 1);
        }
        result.setUrl(url);

        // Headers -H 'key: value'
        Map<String, String> headers = new LinkedHashMap<String, String>();
        java.util.regex.Pattern hp = java.util.regex.Pattern.compile("-H\\s+'([^:]+):\\s*([^']*)'|-H\\s+\"([^:\"]+):\\s*([^\"]*)\"");
        java.util.regex.Matcher hm = hp.matcher(curl);
        while (hm.find()) {
            String key = hm.group(1) != null ? hm.group(1).trim() : hm.group(3).trim();
            String value = hm.group(2) != null ? hm.group(2).trim() : hm.group(4).trim();
            headers.put(key, value);
        }
        result.setHeaders(headers);

        // Content-Type
        String ct = headers.get("content-type");
        if (ct == null) ct = headers.get("Content-Type");
        result.setContentType(ct);

        // Cookie from -b or header
        String cookie = extractByRegex(curl, "-b\\s+'([^']+)'", 1);
        if (cookie == null) cookie = extractByRegex(curl, "--cookie\\s+'([^']+)'", 1);
        if (cookie == null) cookie = headers.get("Cookie");
        result.setCookie(cookie);

        // Body --data-raw / --data
        String body = extractByRegex(curl, "--data-raw\\s+'([^']*)'", 1);
        if (body == null) body = extractByRegex(curl, "--data\\s+'([^']*)'", 1);
        if (body == null) body = extractByRegex(curl, "--data-raw\\s+\"([^\"]*)\"", 1);
        result.setBodyRaw(body);

        // 方法
        result.setMethod(body != null ? "POST" : "GET");

        // 解析 x-www-form-urlencoded 为参数
        if (body != null && (ct == null || ct.contains("application/x-www-form-urlencoded"))) {
            Map<String, String> params = parseForm(body);
            result.setBodyParams(params);
        }
        return result;
    }

    private String extractByRegex(String text, String pattern, int group) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(pattern);
        java.util.regex.Matcher m = p.matcher(text);
        if (m.find()) {
            return m.group(group);
        }
        return null;
    }

    private Map<String, String> parseForm(String form) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        if (form == null || form.length() == 0) return map;
        String[] parts = form.split("&");
        for (int i = 0; i < parts.length; i++) {
            String kv = parts[i];
            int idx = kv.indexOf('=');
            if (idx > 0) {
                String k = kv.substring(0, idx);
                String v = kv.substring(idx + 1);
                try {
                    v = URLDecoder.decode(v, StandardCharsets.UTF_8.name());
                } catch (Exception ignore) {}
                map.put(k, v);
            } else if (kv.length() > 0) {
                map.put(kv, "");
            }
        }
        return map;
    }
}