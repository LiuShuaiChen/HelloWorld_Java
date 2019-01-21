package com.FactoryFunctionMode.Demo01;

public class BmpFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Bmp();
    }
}
