package com.flyingideal.dingtalk.webhook.content;

import com.flyingideal.dingtalk.webhook.DingTalkMessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yanchao
 * @date 2019-12-23 16:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarkdownMessageContent implements DingTalkMessageContent {

    /** 标题 */
    private String title;
    /** 内容 */
    private String text;
    /** 发送地址，可发送给多个群 */
    private List<String> dingTalkServerUrls;

    @Override
    public DingTalkMessageType getDingTalkMessageType() {
        return DingTalkMessageType.markdown;
    }

    @Override
    public List<String> getServerUrls() {
        return dingTalkServerUrls;
    }
}
