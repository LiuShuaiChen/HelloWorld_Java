package com.AdapterPatternModel;

/**
 * 日本电饭煲
 */
public class ElectricCooker {

    private JP110VInterface jp110VInterface;

    public ElectricCooker(JP110VInterface jp110VInterface) {
        this.jp110VInterface = jp110VInterface;
    }

    public void cook(){
        jp110VInterface.connect();
        System.out.println("日本电饭煲开始工作了 开始做饭了....");
    }
}
