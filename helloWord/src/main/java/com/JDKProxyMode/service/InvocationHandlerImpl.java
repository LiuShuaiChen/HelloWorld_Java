package com.JDKProxyMode.service;

import com.ProxyMode.service.IUserDao;
import com.ProxyMode.service.impl.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 */
public class InvocationHandlerImpl implements InvocationHandler {

    //目标代理对象
    private Object targrt;

    public InvocationHandlerImpl(Object targrt) {
        this.targrt = targrt;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("动态代理_开启事务");
        Object invoke = method.invoke(targrt, args);
        System.out.println("动态代理_提交事务");
        return invoke;
    }

    public static void main(String[] args) {

        UserDaoImpl userDao = new UserDaoImpl();
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(userDao);
        ClassLoader classLoader = userDao.getClass().getClassLoader();
        Class<?>[] interfaces = userDao.getClass().getInterfaces();

        //调用动态代理实例
        IUserDao iUserDao = (IUserDao) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        iUserDao.addUser();


    }
}
