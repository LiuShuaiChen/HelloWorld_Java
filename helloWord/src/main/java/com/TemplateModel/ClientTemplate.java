package com.TemplateModel;

/**
 * 什么时候使用模板方法
 * 实现一些操作时,整体步骤很固定,but其中一小部分容易变,这时候可以使用模板方法模式,将容易变的部分抽象出来,供子类实现.
 *
 * 其实在各个框架中,都会与模板方法模式的影子
 *
 * 数据库访问的封装  Junit单元测试 Servlet中关于doGet doPost方法等等调用
 * Hibernate中模板程序
 * Spring的JDBCTemplate  HibernateTemplate等等
 *
 *
 */
public class ClientTemplate {

    public static void main(String[] args) {
        MsgTemplate yiDongMessage = new YiDongMessage();
        yiDongMessage.sendMsg();

        MsgTemplate lianTongMessage = new LianTongMessage();
        lianTongMessage.sendMsg();

    }
}
