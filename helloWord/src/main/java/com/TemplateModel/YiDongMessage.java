package com.TemplateModel;

//移动接口
public class YiDongMessage extends MsgTemplate {
    @Override
    protected void httpRequest() {
        System.out.println("http://yidong.alice.com");
    }
}
