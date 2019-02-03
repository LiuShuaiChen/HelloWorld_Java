package com.CglibProxyModel.service;

import com.ProxyMode.service.impl.UserDaoImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Object target;

    public CglibProxy() {}

    public Object getInstance(Object target){
        this.target = target;
        //操作字节码 生成虚拟子类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public CglibProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        Object invoke = methodProxy.invoke(target, args);
        System.out.println("提交事务");
        return invoke;
    }

}
