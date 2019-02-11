package com.FacadePattern;

// 门面类
public class Computer {
    EamilSmsService eamilSmsService;
    WeChatSmsService weChatSmsService;

    public Computer() {
        eamilSmsService = new EamilSmsServiceImpl();
        weChatSmsService = new WeChatSmsServiceImpl();
    }


    public void sendMsg(){
        eamilSmsService.sendSms();
        weChatSmsService.sendWechat();
    }
}
