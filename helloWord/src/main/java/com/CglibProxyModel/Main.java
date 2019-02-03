package com.CglibProxyModel;

import com.CglibProxyModel.service.CglibProxy;
import com.ProxyMode.service.IUserDao;
import com.ProxyMode.service.impl.UserDaoImpl;

/**
 * 原理：利用asm开源包，对代理对象类的class文件加载进来，通过修改其字节码生成子类来处理。
 *
 * Java动态代理是利用反射机制生成一个实现代理接口的匿名类
 *  在调用具体方法之前调用InvokeHandle来处理
 *  而chlib动态代理是利用asm开源包,对代理对象类的class文件加载进来,通过其修改字节码生成子类处理
 *  Spring中,
 *     1.如果目标对象实现了接口,默认情况下会采用JDK的动态代理实现AOP
 *     2.如果目标对象实现了接口,可以强制使用cglib实现AOP
 *     3.如果目标对象没有实现了接口,必须采用cglib,spring会自动在jdk动态代理和CGLIB之间转换
 *
 */
public class Main {

    /**
     * 日志 控制层打印日志
     * AOP技术 环绕通知 放之前和之后进行拦截参数打印
     * CGLIB没有依赖接口关系 利用反射技术
     *
     * @param args
     */
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        UserDaoImpl instance = (UserDaoImpl) cglibProxy.getInstance(new UserDaoImpl());
        instance.addUser();
        //怎么判断一个类是否实现接口?

    }
}
