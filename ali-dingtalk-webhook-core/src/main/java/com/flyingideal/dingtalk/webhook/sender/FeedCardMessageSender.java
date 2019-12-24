package com.flyingideal.dingtalk.webhook.sender;

import com.dingtalk.api.request.OapiRobotSendRequest;
import com.flyingideal.dingtalk.webhook.content.FeedCardMessageContent;

/**
 * @author yanchao
 * @date 2019-12-24 14:40
 */
public class FeedCardMessageSender implements DingTalkMessageSender<FeedCardMessageContent> {

    @Override
    public void send(FeedCardMessageContent feedCardMessageContent) {
        if (feedCardMessageContent.getServerUrls() == null || feedCardMessageContent.getServerUrls().isEmpty()) {
            throw new IllegalArgumentException("Must specify at least one message sending address");
        }

        OapiRobotSendRequest robotSendRequest = new OapiRobotSendRequest();
        robotSendRequest.setMsgtype(feedCardMessageContent.getDingTalkMessageType().name());
        OapiRobotSendRequest.Feedcard feedCard = new OapiRobotSendRequest.Feedcard();
        feedCard.setLinks(feedCardMessageContent.getLinks());
        robotSendRequest.setFeedCard(feedCard);

        sendMessages(robotSendRequest, feedCardMessageContent);
    }
}
