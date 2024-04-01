package com.be.water.security.service;

import lombok.AllArgsConstructor;
import com.be.water.api.module.message.SmsApi;
import com.be.water.framework.security.mobile.MobileVerifyCodeService;
import org.springframework.stereotype.Service;

/**
 * 短信验证码效验
 *
 */
@Service
@AllArgsConstructor
public class MobileVerifyCodeServiceImpl implements MobileVerifyCodeService {
    private final SmsApi smsApi;

    @Override
    public boolean verifyCode(String mobile, String code) {
        return smsApi.verifyCode(mobile, code);
    }
}