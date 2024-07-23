package com.be.water.market.handler;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.be.water.market.entity.WxUserEntity;
import com.be.water.market.service.WxUserService;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Component
public class UnsubscribeHandler extends AbstractHandler {

    @Autowired
    private WxUserService wxUserService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {
        String openId = wxMessage.getFromUser();
        this.logger.info("取消关注用户 OPENID: " + openId);

        // TODO 可以更新本地数据库为取消关注状态

        String appId = weixinService.getWxMpConfigStorage().getAppId();
        LambdaQueryWrapper<WxUserEntity> wrappers = Wrappers.lambdaQuery();
        wrappers.eq(WxUserEntity::getAppId, appId);
        wrappers.eq(WxUserEntity::getOpenId, openId);
        WxUserEntity userEntity = new WxUserEntity();
        userEntity.setSubscribe(0); // 取消关注
        wxUserService.update(userEntity, wrappers);


        return null;
    }

}
