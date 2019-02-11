package com.TemplateModel;

//联通接口
public class LianTongMessage extends MsgTemplate {
    @Override
    protected void httpRequest() {
        System.out.println("http://liantong.alice.com");
    }
}
