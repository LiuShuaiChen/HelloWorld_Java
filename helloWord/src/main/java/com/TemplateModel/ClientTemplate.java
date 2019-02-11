package com.TemplateModel;

public class ClientTemplate {

    public static void main(String[] args) {
        MsgTemplate yiDongMessage = new YiDongMessage();
        yiDongMessage.sendMsg();

        MsgTemplate lianTongMessage = new LianTongMessage();
        lianTongMessage.sendMsg();

    }
}
