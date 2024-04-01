package com.be.water.message.cache;

import lombok.AllArgsConstructor;
import com.be.water.framework.common.cache.RedisCache;
import com.be.water.message.sms.config.SmsConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 短信平台 Cache
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://be-water.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class SmsPlatformCache {
    private final RedisCache redisCache;

    /**
     * 短信平台轮询KEY
     */
    private final String SMS_ROUND_KEY = "message:sms:round";

    /**
     * 短信平台列表KEY
     */
    private final String SMS_PLATFORM_KEY = "message:sms:platform";

    /**
     * 获取短信轮询值
     */
    public Long getRoundValue() {
        return redisCache.increment(SMS_ROUND_KEY);
    }

    public List<SmsConfig> list() {
        return (List<SmsConfig>) redisCache.get(SMS_PLATFORM_KEY);
    }

    public void save(List<SmsConfig> list) {
        redisCache.set(SMS_PLATFORM_KEY, list);
    }

    public void delete() {
        redisCache.delete(SMS_PLATFORM_KEY);
    }
}