package com.FactoryFunctionMode.Demo01;


public class AodiFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Aodi();
    }
}
