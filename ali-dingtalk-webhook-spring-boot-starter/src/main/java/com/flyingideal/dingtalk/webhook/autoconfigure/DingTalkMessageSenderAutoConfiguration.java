package com.flyingideal.dingtalk.webhook.autoconfigure;

import com.flyingideal.dingtalk.webhook.content.DingTalkMessageContent;
import com.flyingideal.dingtalk.webhook.sender.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yanchao
 * @date 2019-12-24 17:46
 */
@Configuration
@ConditionalOnClass({DingTalkMessageContent.class, DingTalkMessageSender.class})
public class DingTalkMessageSenderAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ActionCardMessageSender actionCardMessageSender() {
        return new ActionCardMessageSender();
    }

    @Bean
    @ConditionalOnMissingBean
    public FeedCardMessageSender feedCardMessageSender() {
        return new FeedCardMessageSender();
    }

    @Bean
    @ConditionalOnMissingBean
    public LinkMessageSender linkMessageSender() {
        return new LinkMessageSender();
    }

    @Bean
    @ConditionalOnMissingBean
    public MarkdownMessageSender markdownMessageSender() {
        return new MarkdownMessageSender();
    }

    @Bean
    @ConditionalOnMissingBean
    public TextMessageSender textMessageSender() {
        return new TextMessageSender();
    }
}
