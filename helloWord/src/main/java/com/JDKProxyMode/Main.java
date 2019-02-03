package com.JDKProxyMode;

import com.JDKProxyMode.service.InvocationHandlerImpl;
import com.ProxyMode.service.IUserDao;
import com.ProxyMode.service.impl.UserDaoImpl;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class Main {
    public static void main(String[] args) {

        UserDaoImpl userDao = new UserDaoImpl();
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(userDao);
        //获取类加载器
        ClassLoader classLoader = userDao.getClass().getClassLoader();
        Class<?>[] interfaces = userDao.getClass().getInterfaces();

        //调用动态代理实例
        IUserDao iUserDao = (IUserDao) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        iUserDao.addUser();

    }
}
