package com.be.water.market.handler;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Component
@Slf4j
public class KfSessionHandler extends AbstractHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) {
        String content = StringUtils.isNotBlank(wxMessage.getContent()) ? wxMessage.getContent().toLowerCase() : "";
        String appId = wxMpService.getWxMpConfigStorage().getAppId();
        log.info("收到微信消息(关键字)：appId={},content={}", appId,content);
        String lang = "zh_CN";//语言
        String fromUser = wxMessage.getFromUser();
        WxMpUser user = null;
        try {
          user = wxMpService.getUserService().userInfo(fromUser, lang);



        } catch (WxErrorException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
