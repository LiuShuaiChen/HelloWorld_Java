package com.AdapterPatternModel;

/**
 * 测试类运行
 */
public class AdaptorTest {

    public static void main(String[] args) {
        CN220VInterfaceImpl cn220VInterface = new CN220VInterfaceImpl();

        PowerAdaptor powerAdaptor = new PowerAdaptor(cn220VInterface);
        ElectricCooker electricCooker = new ElectricCooker(powerAdaptor);
        electricCooker.cook();
    }

}
