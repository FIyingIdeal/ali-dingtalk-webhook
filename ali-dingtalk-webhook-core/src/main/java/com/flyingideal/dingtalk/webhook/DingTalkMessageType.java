package com.flyingideal.dingtalk.webhook;

/**
 * @author yanchao
 * @date 2019-12-23 16:13
 */
public enum DingTalkMessageType {
    /** link类型 */
    link,
    /** text类型 */
    text,
    /** markdown类型 */
    markdown,
    /** 整体跳转ActionCard类型 或  独立跳转ActionCard类型*/
    actionCard,
    /** FeedCard类型，类似与微信订阅号的形式 */
    feedCard;
}
