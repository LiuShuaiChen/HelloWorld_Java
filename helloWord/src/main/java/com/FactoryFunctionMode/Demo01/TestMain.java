package com.FactoryFunctionMode.Demo01;

import java.time.LocalDateTime;
import java.util.Date;

public class TestMain {
    public static void main(String[] args) {
        Car aodi = new AodiFactory().createCar();
        aodi.run();

        Car bmp = new BmpFactory().createCar();
        bmp.run();

        //时间工具类
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = new Date();
        System.out.println(localDateTime);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

    }
}
