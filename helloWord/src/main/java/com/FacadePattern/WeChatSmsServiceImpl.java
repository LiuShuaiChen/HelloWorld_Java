package com.FacadePattern;

public class WeChatSmsServiceImpl implements WeChatSmsService {
    @Override
    public void sendWechat() {
        System.out.println("发送微信消息...");
    }
}
