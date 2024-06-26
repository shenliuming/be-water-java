package com.be.water.message.sms;

import com.be.water.framework.common.exception.ServerException;
import com.be.water.message.enums.SmsPlatformEnum;
import com.be.water.message.sms.config.SmsConfig;

import java.util.Map;

/**
 * 短信 Context
 *
 */
public class SmsContext {
    private final SmsStrategy smsStrategy;

    public SmsContext(SmsConfig config) {
        if (config.getPlatform() == SmsPlatformEnum.ALIYUN.getValue()) {
            this.smsStrategy = new AliyunSmsStrategy(config);
        } else if (config.getPlatform() == SmsPlatformEnum.TENCENT.getValue()) {
            this.smsStrategy = new TencentSmsStrategy(config);
        } else if (config.getPlatform() == SmsPlatformEnum.QINIU.getValue()) {
            this.smsStrategy = new QiniuSmsStrategy(config);
        } else if (config.getPlatform() == SmsPlatformEnum.HUAWEI.getValue()) {
            this.smsStrategy = new HuaweiSmsStrategy(config);
        } else {
            throw new ServerException("未知的短信平台");
        }
    }

    public void send(String mobile, Map<String, String> params) {
        smsStrategy.send(mobile, params);
    }
}