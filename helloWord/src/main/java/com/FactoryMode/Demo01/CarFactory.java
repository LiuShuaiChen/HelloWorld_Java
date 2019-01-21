package com.FactoryMode.Demo01;

import org.codehaus.plexus.util.StringUtils;

public class CarFactory {

    public static Car getCar(String name){

        if(name.equalsIgnoreCase("奥迪")){
            return new Aodi();
        }else if(name.equalsIgnoreCase("宝马")){
            return new Bmp();
        }else {
            return null;
        }
    }
}
