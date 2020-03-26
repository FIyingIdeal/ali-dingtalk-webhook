package com.flyingideal.dingtalk.webhook;

import com.flyingideal.dingtalk.webhook.content.*;
import com.flyingideal.dingtalk.webhook.sender.*;

import java.util.List;

/**
 * 发送消息工具类
 * @author yanchao
 * @date 2019-12-23 18:43
 */
public class DingTalkMessageSenderUtils {

    private static TextMessageSender textMessageSender;
    private static LinkMessageSender linkMessageSender;
    private static MarkdownMessageSender markdownMessageSender;
    private static ActionCardMessageSender actionCardMessageSender;
    private static FeedCardMessageSender feedCardMessageSender;

    static {
        textMessageSender = new TextMessageSender();
        linkMessageSender = new LinkMessageSender();
        markdownMessageSender = new MarkdownMessageSender();
        actionCardMessageSender = new ActionCardMessageSender();
        feedCardMessageSender = new FeedCardMessageSender();
    }

    /**
     * 发送 text 类型消息
     * @param textMessageContent    {@link TextMessageContent}
     */
    public static void sendTextMessage(TextMessageContent textMessageContent, List<String> dingTalkServerUrls) {
        textMessageSender.send(textMessageContent, dingTalkServerUrls);
    }

    /**
     * 发送 link 类型消息
     * @param linkMessageContent    {@link LinkMessageContent}
     */
    public static void sendLinkMessage(LinkMessageContent linkMessageContent, List<String> dingTalkServerUrls) {
        linkMessageSender.send(linkMessageContent, dingTalkServerUrls);
    }

    /**
     * 发送 markdown 类型消息
     * @param markdownMessageContent    {@link MarkdownMessageContent}
     */
    public static void sendMarkdownMessage(MarkdownMessageContent markdownMessageContent, List<String> dingTalkServerUrls) {
        markdownMessageSender.send(markdownMessageContent, dingTalkServerUrls);
    }

    /**
     * 发送 actionCard 类型消息
     * @param actionCardMessageContent  {@link ActionCardMessageContent}
     */
    public static void sendActionCardMessage(ActionCardMessageContent actionCardMessageContent, List<String> dingTalkServerUrls) {
        actionCardMessageSender.send(actionCardMessageContent, dingTalkServerUrls);
    }

    /**
     * 发送 feedCard 类型消息
     * @param feedCardMessageContent    {@link FeedCardMessageContent}
     */
    public static void sendFeedCardMessage(FeedCardMessageContent feedCardMessageContent, List<String> dingTalkServerUrls) {
        feedCardMessageSender.send(feedCardMessageContent, dingTalkServerUrls);
    }
}
