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

}
