# 阿里巴巴钉钉 webhook 机器人发送群消息组件

## 使用

### maven引入

```xml
<dependency>
    <groupId>com.flyingideal</groupId>
    <artifactId>ali-dingtalk-webhook-core</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>

<!-- 需要引入日志框架，这里引入 logback -->
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
</dependency>
```

### 发消息

发消息前需要指定一个发消息的地址，即群消息机器人的 webhook 地址，是一个 List ：
```java
private List<String> dingTalkServerUrls = Arrays.asList("https://oapi.dingtalk.com/robot/send?access_token==xxxx");
```

- 发送 text 类型消息

```java
// 构造 MessageContent
TextMessageContent content = new TextMessageContent();
content.setXXX();   // 设置属性

// 构造 MessageSender
TextMessageSender textMessageSender = new TextMessageSender();

// 发送消息
textMessageSender.send(content);
```

更简单的方式：

```java
TextMessageContent content = new TextMessageContent();
content.setXXX();   // 设置属性

// 使用 DingTalkMessageSenderUtils 发送指定类型的消息
DingTalkMessageSenderUtils.sendTextMessage(content);

```

- 发送 link 类型消息

```java
LinkMessageContent linkMessageContent = new LinkMessageContent("title", "text",
                "https://www.baidu.com", dingTalkServerUrls);
        DingTalkMessageSenderUtils.sendLinkMessage(linkMessageContent);
```

- 发送 markdown 类型消息

```java
MarkdownMessageContent markdownMessageContent = new MarkdownMessageContent("title", "markdown message", dingTalkServerUrls);
        DingTalkMessageSenderUtils.sendMarkdownMessage(markdownMessageContent);
```

- 发送 ActionCard 类型消息
    - 发送单按钮消息
    ```java
    ActionCardMessageContent messageContent = new ActionCardMessageContent(
            "title",
            "markdown text",
            "0", // btnOrientation: 0-按钮竖直排列，1-按钮横向排列
            "0", // hideAvatar: 0-正常发消息者头像，1-隐藏发消息者头像
            "阅读全文",   // singleTitle
            "https://www.dingtalk.com/",  // singleURL
            dingTalkServerUrls
    );
    DingTalkMessageSenderUtils.sendActionCardMessage(messageContent);
    ```
    
    - 发送多按钮消息
    ```java
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
            "title",
            "markdown text",
            "0", // btnOrientation: 0-按钮竖直排列，1-按钮横向排列
            "0", // hideAvatar: 0-正常发消息者头像，1-隐藏发消息者头像
            btns,// btns
            dingTalkServerUrls
    );
    DingTalkMessageSenderUtils.sendActionCardMessage(messageContent);
    ```

- 发送 FeedCard 类型消息

```java
OapiRobotSendRequest.Links links0 = new OapiRobotSendRequest.Links();
links0.setTitle("乔帮主的Apple咖啡厅");
links0.setPicURL("pic url");
links0.setMessageURL("message url");

OapiRobotSendRequest.Links links1 = new OapiRobotSendRequest.Links();
links1.setTitle("时代的火车向前开");
links1.setPicURL("pic url");
links1.setMessageURL("message url");

List<OapiRobotSendRequest.Links> links = new ArrayList<>();
links.add(links0);
links.add(links1);

FeedCardMessageContent messageContent = new FeedCardMessageContent(
        links,
        dingTalkServerUrls
);

DingTalkMessageSenderUtils.sendFeedCardMessage(messageContent);
```

参考

[钉钉机器人开发文档](https://ding-doc.dingtalk.com/doc#/serverapi2/qf2nxq)