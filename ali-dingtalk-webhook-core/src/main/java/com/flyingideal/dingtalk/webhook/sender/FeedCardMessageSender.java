package com.flyingideal.dingtalk.webhook.sender;

import com.dingtalk.api.request.OapiRobotSendRequest;
import com.flyingideal.dingtalk.webhook.content.FeedCardMessageContent;

import java.util.List;

/**
 * @author yanchao
 * @date 2019-12-24 14:40
 */
public class FeedCardMessageSender implements DingTalkMessageSender<FeedCardMessageContent> {

    @Override
    public void send(FeedCardMessageContent feedCardMessageContent, List<String> dingTalkServerUrls) {
        if (dingTalkServerUrls == null || dingTalkServerUrls.isEmpty()) {
            throw new IllegalArgumentException("Must specify at least one message sending address");
        }

        OapiRobotSendRequest robotSendRequest = new OapiRobotSendRequest();
        robotSendRequest.setMsgtype(feedCardMessageContent.getDingTalkMessageType().name());
        OapiRobotSendRequest.Feedcard feedCard = new OapiRobotSendRequest.Feedcard();
        feedCard.setLinks(feedCardMessageContent.getLinks());
        robotSendRequest.setFeedCard(feedCard);

        sendMessages(robotSendRequest, feedCardMessageContent, dingTalkServerUrls);
    }
}
