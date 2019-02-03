package com.ProxyMode;

import com.ProxyMode.service.impl.UserDaoImpl;

/**
 * 代理模式
 * 通过代理对象的访问,可以详细访问某对象的方法,在这个方法调用处理,或者调用后处理
 * 即AOP微实现
 * AOP核心技术面向切面编程
 *
 * 比如事务管理方式
 *  前置通知 后置通知 环绕通知 最终通知
 *  spring aop通知(advice)分成五类：
 * 前置通知[Before advice]：在连接点前面执行，前置通知不会影响连接点的执行，除非此处抛出异常。
 * 正常返回通知[After returning advice]：在连接点正常执行完成后执行，如果连接点抛出异常，则不会执行。
 * 异常返回通知[After throwing advice]：在连接点抛出异常后执行。
 * 返回通知[After (finally) advice]：在连接点执行完成后执行，不管是正常执行完成，还是抛出异常，都会执行返回通知中的内容。
 * 环绕通知[Around advice]：环绕通知围绕在连接点前后，比如一个方法调用的前后。这是最强大的通知类型，能在方法调用前后自定义一些操作。环绕通知还需要负责决定是继续处理join point(调用ProceedingJoinPoint的proceed方法)还是中断执行。
 *
 * SpringAOP、事物原理、日志打印、权限控制、远程调用、安全代理 可以隐蔽真实角色
 *
 * 静态代理:一个代理类只能代理一个类
 *
 * 动态代理:一个代理类可以代理N个类
 */
public class Main {

    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.addUser();
    }
}
