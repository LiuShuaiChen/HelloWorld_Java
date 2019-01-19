package com.DesignMode.Demo02;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 1.什么是反射机制
 *  正在运行 动态获取类的信息
 *
 *  Java源代码--.class文件 字节码
 * 2.使用反射机制获取类的属性 方法 实例化对象
 *  学习Spring框架 hibernate框架 手写ORM
 *
 * 不使用new 如何创建对象?
 *  使用反射机制
 *
 * 反射应用场景
 *  1.jdbc连接  SpirngIOC底层使用反射机制+DOM4J
 *  2.框架hibernate mybatis
 *
 * 思考:怎么防止被反射攻击?
 * 方法设置私有化权限
 */
public class HelloWorld {

    public static void main(String[] args) {
        // 创建对象的方式
        UserEntity userEntity = new UserEntity();
        userEntity.setName("HelloWorld");
        System.out.println(userEntity.toString());

        // 使用Java反射创建对象
        try {
            Class<?> aClass = Class.forName("com.DesignMode.Demo02.UserEntity");
            //使用反射机制创建对象
            UserEntity userEntity1 = (UserEntity) aClass.newInstance();
            userEntity1.setName("aaaaaaaaaaaa  反射对象");
            System.out.println(userEntity1.toString());

            // 使用反射机制获取类的信息

            // 获取当前类有哪些方法
            Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                //任何类都会继承Object的方法
                System.out.println(method.getName());
            }

            System.out.println("===========================");
            //获取类的属性
//            Field[] fields = aClass.getFields();
            Field[] fields = aClass.getDeclaredFields(); // 暴力获取属性字段 忽略权限
            for (Field field : fields) {
                System.out.println(field.getName());
            }

            Constructor<?> constructors = aClass.getConstructor(String.class);
            // 利用有参构造
            UserEntity alice = (UserEntity) constructors.newInstance("alice");
            System.out.println(alice.getName());

            constructors.setAccessible(false);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
