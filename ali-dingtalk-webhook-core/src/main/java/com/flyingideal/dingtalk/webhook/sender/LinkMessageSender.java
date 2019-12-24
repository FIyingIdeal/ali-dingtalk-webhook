package com.flyingideal.dingtalk.webhook.sender;

import com.dingtalk.api.request.OapiRobotSendRequest;
import com.flyingideal.dingtalk.webhook.content.LinkMessageContent;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;

/**
 * 发送 link 类型消息
 * @author yanchao
 * @date 2019-12-23 18:36
 */
@Slf4j
public class LinkMessageSender implements MessageSender<LinkMessageContent> {

    @Override
    public void send(LinkMessageContent linkMessageContent) {
        if (linkMessageContent.getServerUrls() == null || linkMessageContent.getServerUrls().isEmpty()) {
            throw new IllegalArgumentException("Must specify at least one message sending address");
        }
        OapiRobotSendRequest robotSendRequest = new OapiRobotSendRequest();
        robotSendRequest.setMsgtype(linkMessageContent.getDingTalkMessageType().name());
        OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
        link.setTitle(linkMessageContent.getTitle());
        link.setText(linkMessageContent.getText());
        link.setMessageUrl(linkMessageContent.getLinkMessageUrl());
        robotSendRequest.setLink(link);

        sendMessages(robotSendRequest, linkMessageContent);
    }
}