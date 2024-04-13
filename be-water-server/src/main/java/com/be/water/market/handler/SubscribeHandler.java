package com.be.water.market.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.be.water.market.service.WxAccountConfigService;
import com.be.water.market.service.WxUserService;
import com.be.water.market.vo.WxAccountConfigVO;
import com.be.water.market.vo.WxUserVO;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutImageMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Component
public class SubscribeHandler extends AbstractHandler {

    @Autowired
    private WxAccountConfigService wxAccountConfigService;

    @Autowired
    private WxUserService wxUserService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) throws WxErrorException {

        this.logger.info("收到微信公众号[关注] OPENID: " + wxMessage.getFromUser());
        //语言
        String lang = "zh_CN";
        String fromUser = wxMessage.getFromUser();
        String appId = weixinService.getWxMpConfigStorage().getAppId();

        String backMediaId = null;//回复资源
        String backMessage = null;//回复消息
        String welcomeBackMessage = null;//关注欢迎消息
        String ucode = null; //流量人员code

        // 获取微信用户基本信息
        try {
            WxMpUser userWxInfo = weixinService.getUserService()
                .userInfo(wxMessage.getFromUser(), lang);
            if (userWxInfo != null) {
                // TODO 可以添加关注用户到本地数据库
            }
            WxAccountConfigVO vo = wxAccountConfigService.getByAppId(appId);
            JSONObject object = JSON.parseObject(vo.getWelcomeMessage());
            welcomeBackMessage = object.get("default").toString();
            this.logger.info("回复微信消息(关注)：backMediaId={},backMessage={},welcomeBackMessage={}", backMediaId,backMessage,welcomeBackMessage);

            //回复欢迎消息
            if(StringUtils.isNotEmpty(welcomeBackMessage)){
                sendKefuMessage(WxMpKefuMessage.TEXT().content(welcomeBackMessage).toUser(wxMessage.getFromUser()).build(),weixinService);
            }

            //回复客服消息
            if(StringUtils.isNotEmpty(backMessage)){
                sendKefuMessage(WxMpKefuMessage.TEXT().content(backMessage).toUser(wxMessage.getFromUser()).build(),weixinService);
            }

            //回复资源
            if(StringUtils.isNotEmpty(backMediaId)){
                WxMpXmlOutImageMessage imageMessage = WxMpXmlOutImageMessage.IMAGE().mediaId(backMediaId).
                  fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser()).build();
                return imageMessage;
            }

            //保存用户信息
            if(null != userWxInfo){
//            wxService.saveWxMpUser(user, null);
//            wxmUserService.saveWxmUser(appId,user);
                WxUserVO wxUserVO = new WxUserVO();
                wxUserVO.setAppId(appId);
                wxUserVO.setUnionId(userWxInfo.getUnionId());
                wxUserVO.setOpenId(userWxInfo.getOpenId());
                wxUserVO.setNickname(userWxInfo.getNickname());
                wxUserVO.setAvatar(userWxInfo.getHeadImgUrl());
                wxUserVO.setQrSceneStr(userWxInfo.getQrSceneStr());
                wxUserVO.setSubscribeScene(userWxInfo.getSubscribeScene());
                wxUserVO.setSubscribe(1);
                wxUserVO.setSubscribeTime(new Date(userWxInfo.getSubscribeTime()*1000));
                if(null != userWxInfo.getTagIds() && userWxInfo.getTagIds().length > 0) {
                    wxUserVO.setTagidList(userWxInfo.getTagIds().toString());
                }
                wxUserService.save(wxUserVO);
            }



        } catch (WxErrorException e) {
            if (e.getError().getErrorCode() == 48001) {
                this.logger.info("该公众号没有获取用户信息权限！");
            }
        }



        return null;
    }

    /**
     * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
     */
    private WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage)
        throws Exception {
        //TODO
        return null;
    }

    public void sendKefuMessage(WxMpKefuMessage message, WxMpService weixinService) {

        try {
            weixinService.getKefuService().sendKefuMessage(message);
            // 所有的发送信息都需要经过审核 暂时不处理
//            messageProcessingHandler.processWxMpKefuMessage(message);
        } catch (Exception e) {
            // 发送异常处理逻辑
            this.logger.info("Failed to send kefu message. Error: {}" ,e);
        }
    }
}
