package com.flyingideal.dingtalk.webhook.content;

import com.flyingideal.dingtalk.webhook.DingTalkMessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yanchao
 * @date 2019-12-23 16:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TextMessageContent implements DingTalkMessageContent {

    /** 消息内容 */
    private String content;

    /** at（@）用户列表 */
    private List<String> atMobiles;

    /** 发送地址，可发送给多个群 */
    private List<String> dingTalkServerUrls;

    @Override
    public DingTalkMessageType getDingTalkMessageType() {
        return DingTalkMessageType.text;
    }

    @Override
    public List<String> getServerUrls() {
        return dingTalkServerUrls;
    }

    @Override
    public String getTitle() {
        return this.content;
    }
}
