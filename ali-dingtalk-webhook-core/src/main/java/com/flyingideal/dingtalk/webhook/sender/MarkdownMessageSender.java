package com.flyingideal.dingtalk.webhook.sender;

import com.dingtalk.api.request.OapiRobotSendRequest;
import com.flyingideal.dingtalk.webhook.content.MarkdownMessageContent;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 发送 markdown 类型的消息
 * @author yanchao
 * @date 2019-12-23 18:38
 */
@Slf4j
public class MarkdownMessageSender implements DingTalkMessageSender<MarkdownMessageContent> {

    @Override
    public void send(MarkdownMessageContent markdownMessageContent, List<String> dingTalkServerUrls) {
        if (dingTalkServerUrls == null || dingTalkServerUrls.isEmpty()) {
            throw new IllegalArgumentException("Must specify at least one message sending address");
        }
        OapiRobotSendRequest robotSendRequest = new OapiRobotSendRequest();
        robotSendRequest.setMsgtype(markdownMessageContent.getDingTalkMessageType().name());
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle(markdownMessageContent.getTitle());
        markdown.setText(markdownMessageContent.getText());
        robotSendRequest.setMarkdown(markdown);

        sendMessages(robotSendRequest, markdownMessageContent, dingTalkServerUrls);
    }
}
