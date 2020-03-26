package com.flyingideal.dingtalk.webhook;

import com.dingtalk.api.request.OapiRobotSendRequest;
import com.flyingideal.dingtalk.webhook.content.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yanchao
 * @date 2019-12-23 18:54
 */
public class DingTalkSenderUtilTests {

    private List<String> dingTalkServerUrls = Arrays.asList("https://oapi.dingtalk.com/robot/send?access_token=xxxx");

    @Test
    public void textMessageSenderTest() {
        TextMessageContent textMessageContent = new TextMessageContent("测试", null);
        DingTalkMessageSenderUtils.sendTextMessage(textMessageContent, dingTalkServerUrls);
    }

    @Test
    public void linkMessageSenderTest() {
        LinkMessageContent linkMessageContent = new LinkMessageContent("百度", "度娘",
                "https://www.baidu.com");
        DingTalkMessageSenderUtils.sendLinkMessage(linkMessageContent, dingTalkServerUrls);
    }

    @Test
    public void markdownSenderTest() {
        MarkdownMessageContent markdownMessageContent = new MarkdownMessageContent("好未来", "**TAL** \n " +
                "![screenshot](@lADOpwk3K80C0M0FoA) \n");
        DingTalkMessageSenderUtils.sendMarkdownMessage(markdownMessageContent, dingTalkServerUrls);
    }

    @Test
    public void singleActionCardMessageSenderTest() {
        ActionCardMessageContent messageContent = new ActionCardMessageContent(
                "乔布斯 20 年前想打造一间苹果咖啡厅，而它正是 Apple Store 的前身",
                "![screenshot](@lADOpwk3K80C0M0FoA) \n" +
                        " ### 乔布斯 20 年前想打造的苹果咖啡厅 \n" +
                        " Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划",
                "0",
                "0",
                "阅读全文",
                "https://www.dingtalk.com/");
        DingTalkMessageSenderUtils.sendActionCardMessage(messageContent, dingTalkServerUrls);
    }

    @Test
    public void multiActionCardMessageSenderTest() {
        OapiRobotSendRequest.Btns btns0 = new OapiRobotSendRequest.Btns();
        btns0.setTitle("内容不错");
        btns0.setActionURL("https://www.dingtalk.com/");
        OapiRobotSendRequest.Btns btns1 = new OapiRobotSendRequest.Btns();
        btns1.setTitle("不感兴趣");
        btns1.setActionURL("https://www.dingtalk.com/");
        List<OapiRobotSendRequest.Btns> btns = new ArrayList<>();
        btns.add(btns0);
        btns.add(btns1);

        ActionCardMessageContent messageContent = new ActionCardMessageContent(
                "乔布斯 20 年前想打造一间苹果咖啡厅，而它正是 Apple Store 的前身",
                "![screenshot](@lADOpwk3K80C0M0FoA) \n" +
                        " ### 乔布斯 20 年前想打造的苹果咖啡厅 \n" +
                        " Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划",
                "0",
                "0",
                btns
        );
        DingTalkMessageSenderUtils.sendActionCardMessage(messageContent, dingTalkServerUrls);
    }

    @Test
    public void feedCardMessageSenderTest() {
        OapiRobotSendRequest.Links links0 = new OapiRobotSendRequest.Links();
        links0.setTitle("乔帮主的Apple咖啡厅");
        links0.setPicURL("@lADOpwk3K80C0M0FoA");
        links0.setMessageURL("https://www.dingtalk.com/");

        OapiRobotSendRequest.Links links1 = new OapiRobotSendRequest.Links();
        links1.setTitle("时代的火车向前开");
        links1.setPicURL("https://www.canva.cn/learn/wp-content/uploads/sites/17/2019/09/Snipaste_2019-09-24_15-21-59.png");
        links1.setMessageURL("https://www.dingtalk.com/s?__biz=MzA4NjMwMTA2Ng==&mid=2650316842&idx=1&sn=60da3ea2b29f1dcc43a7c8e4a7c97a16&scene=2&srcid=09189AnRJEdIiWVaKltFzNTw&from=timeline&isappinstalled=0&key=&ascene=2&uin=&devicetype=android-23&version=26031933&nettype=WIFI");

        List<OapiRobotSendRequest.Links> links = new ArrayList<>();
        links.add(links0);
        links.add(links1);

        FeedCardMessageContent messageContent = new FeedCardMessageContent(links);

        DingTalkMessageSenderUtils.sendFeedCardMessage(messageContent, dingTalkServerUrls);
    }
}
