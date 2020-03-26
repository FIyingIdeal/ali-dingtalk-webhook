package com.flyingideal.dingtalk.webhook.sender;

import com.dingtalk.api.request.OapiRobotSendRequest;
import com.flyingideal.dingtalk.webhook.content.ActionCardMessageContent;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author yanchao
 * @date 2019-12-23 20:14
 */
@Slf4j
public class ActionCardMessageSender implements DingTalkMessageSender<ActionCardMessageContent> {

    @Override
    public void send(ActionCardMessageContent actionCardMessageContent, List<String> dingTalkServerUrls) {
        if (dingTalkServerUrls == null || dingTalkServerUrls.isEmpty()) {
            throw new IllegalArgumentException("Must specify at least one message sending address");
        }

        OapiRobotSendRequest robotSendRequest = new OapiRobotSendRequest();
        robotSendRequest.setMsgtype(actionCardMessageContent.getDingTalkMessageType().name());
        OapiRobotSendRequest.Actioncard actionCard = new OapiRobotSendRequest.Actioncard();
        actionCard.setTitle(actionCardMessageContent.getTitle());
        actionCard.setText(actionCardMessageContent.getText());
        actionCard.setHideAvatar(actionCardMessageContent.getHideAvatar());
        actionCard.setBtnOrientation(actionCardMessageContent.getBtnOrientation());
        String singleTitle = actionCardMessageContent.getSingleTitle();
        String singleURL = actionCardMessageContent.getSingleURL();
        // 单按钮方案与多按钮方案不可能同时出现，若同时提供，则多按钮方案将不会展示
        // 单按钮方案
        actionCard.setSingleTitle(singleTitle);
        actionCard.setSingleURL(singleURL);
        // 多按钮方案
        actionCard.setBtns(actionCardMessageContent.getBtns());
        robotSendRequest.setActionCard(actionCard);

        sendMessages(robotSendRequest, actionCardMessageContent, dingTalkServerUrls);
    }
}
