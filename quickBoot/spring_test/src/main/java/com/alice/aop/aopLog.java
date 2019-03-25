package com.alice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class aopLog {

    //aop的几种通知方式
    //前置通知
    @Before("execution(* com.alice.service.impl.UserServiceImpl.addUser())")
    public void before(){
        System.out.println("前置通知:在方法之前通知...");
    }

    @After("execution(* com.alice.service.impl.UserServiceImpl.addUser())")
    public void after(){
        System.out.println("后置通知:在方法之后通知...");
    }

    //运行时通知
    @AfterReturning("execution(* com.alice.service.impl.UserServiceImpl.addUser())")
    public void running(){
        System.out.println("运行时通知");
    }

    //环绕通知
    @Around("execution(* com.alice.service.impl.UserServiceImpl.addUser())")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("环绕通知,调用方法之前执行....");
        try {
            proceedingJoinPoint.proceed();//如果方法抛出异常 则不会执行下面的代码
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕通知,调用方法之后执行....");
    }

    @AfterThrowing("execution(* com.alice.service.impl.UserServiceImpl.addUser())")
    public void exception(){
        System.out.println("异常通知");
    }
}
