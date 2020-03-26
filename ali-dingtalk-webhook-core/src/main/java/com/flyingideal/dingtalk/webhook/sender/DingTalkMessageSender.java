package com.flyingideal.dingtalk.webhook.sender;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.flyingideal.dingtalk.webhook.content.DingTalkMessageContent;
import com.taobao.api.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 发送消息接口类
 * @author yanchao
 * @date 2019-12-23 18:08
 */
public interface DingTalkMessageSender<M extends DingTalkMessageContent> {

    Logger logger = LoggerFactory.getLogger(DingTalkMessageSender.class);

    /**
     * 发送消息方法
     * @param messageContent    {@link DingTalkMessageContent}
     * @param dingTalkServerUrls 发送地址，可发送给多个群
     */
    void send(M messageContent, List<String> dingTalkServerUrls);

    /**
     * 发送消息给指定的 webhock 地址
     * @param robotSendRequest  {@link OapiRobotSendRequest}
     * @param messageContent    {@link DingTalkMessageContent}
     * @param dingTalkServerUrls 发送地址，可发送给多个群
     */
    default void sendMessages(OapiRobotSendRequest robotSendRequest, DingTalkMessageContent messageContent,
                              List<String> dingTalkServerUrls) {
        for (String dingTalkServerUrl : dingTalkServerUrls) {
            try {
                if (doSendMessage(robotSendRequest, dingTalkServerUrl)) {
                    logger.info("DingTalk {} message send success : title [{}], serverUrl [{}]",
                            robotSendRequest.getMsgtype(), messageContent.getTitle(), dingTalkServerUrl);
                } else {
                    logger.warn("DingTalk {} message send fail : title [{}], serverUrl [{}]" +
                            robotSendRequest.getMsgtype(), messageContent.getTitle(), dingTalkServerUrl);
                }
            } catch (ApiException e) {
                logger.error("DingTalk {} message send error : title [{}], serverUrl [{}]",
                        robotSendRequest.getMsgtype(), messageContent.getTitle(), dingTalkServerUrl, e);
                // do nothing~
            }
        }
    }

    /**
     * 实际发送消息方法
     * @param robotSendRequest      {@link OapiRobotSendRequest}
     * @param dingTalkServerUrl     发送地址
     * @return                      true: 发送成功；false: 发送失败
     * @throws ApiException         {@link ApiException}
     */
    default boolean doSendMessage(OapiRobotSendRequest robotSendRequest, String dingTalkServerUrl)
            throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(dingTalkServerUrl);
        OapiRobotSendResponse response = client.execute(robotSendRequest);
        return response.isSuccess();
    }

}
