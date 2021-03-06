package com.flyingideal.dingtalk.webhook.content;

import com.flyingideal.dingtalk.webhook.DingTalkMessageType;

import java.io.Serializable;
/**
 * @author yanchao
 * @date 2019-12-23 16:11
 */
public interface DingTalkMessageContent extends Serializable {
    /**
     * 获取消息类型
     * @return  {@link DingTalkMessageType}
     */
    DingTalkMessageType getDingTalkMessageType();

    /**
     * 获取 title 消息，对于 text 类型消息，返回消息内容
     * @return  title 内容
     */
    String getTitle();

}
