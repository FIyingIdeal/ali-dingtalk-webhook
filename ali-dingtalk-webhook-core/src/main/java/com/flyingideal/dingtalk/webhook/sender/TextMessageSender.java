package com.flyingideal.dingtalk.webhook.sender;

import com.dingtalk.api.request.OapiRobotSendRequest;
import com.flyingideal.dingtalk.webhook.content.TextMessageContent;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 发送 text 类型的消息
 * @author yanchao
 * @date 2019-12-23 18:07
 */
@Slf4j
public class TextMessageSender implements DingTalkMessageSender<TextMessageContent> {

    @Override
    public void send(TextMessageContent textMessageContent, List<String> dingTalkServerUrls) {
        if (dingTalkServerUrls == null || dingTalkServerUrls.isEmpty()) {
            throw new IllegalArgumentException("Must specify at least one message sending address");
        }
        OapiRobotSendRequest robotSendRequest = new OapiRobotSendRequest();
        robotSendRequest.setMsgtype(textMessageContent.getDingTalkMessageType().name());
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent(textMessageContent.getContent());
        robotSendRequest.setText(text);
        if (textMessageContent.getAtMobiles()!= null && !textMessageContent.getAtMobiles().isEmpty()) {
            OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
            at.setAtMobiles(textMessageContent.getAtMobiles());
            robotSendRequest.setAt(at);
        }

        sendMessages(robotSendRequest, textMessageContent, dingTalkServerUrls);
    }
}
