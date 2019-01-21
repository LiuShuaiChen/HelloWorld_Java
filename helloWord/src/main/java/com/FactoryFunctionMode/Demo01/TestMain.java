package com.FactoryFunctionMode.Demo01;

public class TestMain {
    public static void main(String[] args) {
        Car aodi = new AodiFactory().createCar();
        aodi.run();

        Car bmp = new BmpFactory().createCar();
        bmp.run();

    }
}
