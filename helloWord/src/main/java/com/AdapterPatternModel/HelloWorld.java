package com.AdapterPatternModel;

/**
 *  适配器模式
 *  在设计模式中,适配器模式有时候也被称作包装样式或者包装.
 *  将一个类的借口转接成用户所期待的.一个适配使得因接口不兼容而不能在一起工作的类工作在一起,做法就是将类自己的接口包裹在一个已经存在的类中.
 *
 *  日本电压110V 中国电压220V
 *
 *  适配器分为，类适配器、对象适配、接口适配方式
 *  类适配器方式采用继承方式，对象适配方式使用构造函数传递
 *
 *  OutputStreamWriter：是Writer的子类，将输出的字符流变为字节流，即：将一个字符流的输出对象变为字节流的输出对象。
 *  InputStreamReader：是Reader的子类，将输入的字节流变为字符流，即：将一个字节流的输入对象变为字符流的输入对象。
 *  SpringMVC 适配器
 */
public class HelloWorld {
    public static void main(String[] args) {
        CN220VInterfaceImpl cn220VInterface = new CN220VInterfaceImpl();

        PowerAdaptor powerAdaptor = new PowerAdaptor(cn220VInterface);
        ElectricCooker electricCooker = new ElectricCooker(powerAdaptor);
        electricCooker.cook();
    }
}
