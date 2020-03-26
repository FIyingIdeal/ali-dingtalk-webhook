package com.flyingideal.dingtalk.webhook.content;

import com.dingtalk.api.request.OapiRobotSendRequest;
import com.flyingideal.dingtalk.webhook.DingTalkMessageType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ActionCard 类型消息消息体
 * @author yanchao
 * @date 2019-12-23 20:07
 */
@Data
@NoArgsConstructor
public class ActionCardMessageContent implements DingTalkMessageContent {

    /**
     * 首屏会话透出的展示内容
     */
    private String title;

    /**
     * markdown格式的消息
     */
    private String text;

    /**
     * 非必须
     * 0-按钮竖直排列，1-按钮横向排列
     */
    private String btnOrientation;

    /**
     * 0-正常发消息者头像，1-隐藏发消息者头像
     */
    private String hideAvatar;

    /**
     * 单个按钮的方案。(设置此项和 singleURL 后， btns 无效)
     */
    private String singleTitle;

    /**
     * 点击singleTitle按钮触发的URL
     */
    private String singleURL;

    /**
     * 多个按钮的方案，{@link com.dingtalk.api.request.OapiRobotSendRequest.Btns}是按钮的信息：title-按钮方案，actionURL-点击按钮触发的URL
     */
    private List<OapiRobotSendRequest.Btns> btns;

    public ActionCardMessageContent(String title, String text, String btnOrientation, String hideAvatar,
                                    String singleTitle, String singleURL) {
        this.title = title;
        this.text = text;
        this.btnOrientation = btnOrientation;
        this.hideAvatar = hideAvatar;
        this.singleTitle = singleTitle;
        this.singleURL = singleURL;
    }

    public ActionCardMessageContent(String title, String text, String btnOrientation, String hideAvatar,
                                    List<OapiRobotSendRequest.Btns> btns) {
        this.title = title;
        this.text = text;
        this.btnOrientation = btnOrientation;
        this.hideAvatar = hideAvatar;
        this.btns = btns;
    }

    @Override
    public DingTalkMessageType getDingTalkMessageType() {
        return DingTalkMessageType.actionCard;
    }
}
