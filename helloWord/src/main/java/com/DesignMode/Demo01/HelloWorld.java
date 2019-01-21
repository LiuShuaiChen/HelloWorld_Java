package com.DesignMode.Demo01;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 设计模式
 *
 * 设计模式分为三大类
 *  创建型模式:
 *      工厂方法模式 抽象工厂模式 单例模式  建造者模式  原型模式
 *  结构型模式:
 *      适配器模式 装饰器模式 代理模式 外观模式 桥接模式 组合模式 享元模式
 *  行为型模式:
 *      策略模式 模板方法模式 观察者模式 迭代子模式 责任链模式 命令模式 备忘录模式 状态模式 访问者模式 中介者模式 解释器模式
 */
public class HelloWorld {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HelloWorld() {
    }

    public HelloWorld(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                System.out.println(i);
            }
        }).start();


        Class<HelloWorld> helloWorldClass = HelloWorld.class;

        Class<?>[] classes = helloWorldClass.getClasses();

        try {

//            HelloWorld helloWorld = (HelloWorld) Class.forName("com.DesignMode.Demo01.HelloWorld");

            Class<?> classUser =Class.forName("com.DesignMode.Demo01.HelloWorld");
            Object o = classUser.newInstance();

            //获取当前所有的属性 字段
            Field[] declaredFields = classUser.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                System.out.println(declaredField.getName());
            }

            //获取当前类所有的方法
            Method[] declaredMethods = classUser.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                System.out.println("######################################1");
                System.out.println(declaredMethod);
                System.out.println(declaredMethod.getModifiers());
                System.out.println(declaredMethod.getName());
                System.out.println("######################################2");

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        boolean flag = executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("flagaaaa");
//            }
//        }).isDone();
//        System.out.println(flag);

//        executorService.shutdown();

    }
}
