package com.flyingideal.dingtalk.webhook.content;

import com.dingtalk.api.request.OapiRobotSendRequest;
import com.flyingideal.dingtalk.webhook.DingTalkMessageType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * FeedCard 类型消息消息体
 * @author yanchao
 * @date 2019-12-24 14:39
 */
@Data
@AllArgsConstructor
public class FeedCardMessageContent implements DingTalkMessageContent {

    /**
     * {@link com.dingtalk.api.request.OapiRobotSendRequest.Links}
     */
    private List<OapiRobotSendRequest.Links> links;

    /** 发送地址，可发送给多个群 */
    private List<String> dingTalkServerUrls;

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public DingTalkMessageType getDingTalkMessageType() {
        return DingTalkMessageType.feedCard;
    }

    @Override
    public List<String> getServerUrls() {
        return this.dingTalkServerUrls;
    }
}
