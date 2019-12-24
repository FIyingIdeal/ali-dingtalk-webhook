package com.flyingideal.dingtalk.webhook;

import com.flyingideal.dingtalk.webhook.content.*;
import com.flyingideal.dingtalk.webhook.sender.*;

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
    public static void sendTextMessage(TextMessageContent textMessageContent) {
        textMessageSender.send(textMessageContent);
    }

    /**
     * 发送 link 类型消息
     * @param linkMessageContent    {@link LinkMessageContent}
     */
    public static void sendLinkMessage(LinkMessageContent linkMessageContent) {
        linkMessageSender.send(linkMessageContent);
    }

    /**
     * 发送 markdown 类型消息
     * @param markdownMessageContent    {@link MarkdownMessageContent}
     */
    public static void sendMarkdownMessage(MarkdownMessageContent markdownMessageContent) {
        markdownMessageSender.send(markdownMessageContent);
    }

    /**
     * 发送 actionCard 类型消息
     * @param actionCardMessageContent  {@link ActionCardMessageContent}
     */
    public static void sendActionCardMessage(ActionCardMessageContent actionCardMessageContent) {
        actionCardMessageSender.send(actionCardMessageContent);
    }

    /**
     * 发送 feedCard 类型消息
     * @param feedCardMessageContent    {@link FeedCardMessageContent}
     */
    public static void sendFeedCardMessage(FeedCardMessageContent feedCardMessageContent) {
        feedCardMessageSender.send(feedCardMessageContent);
    }
}
