package com.alice;


import com.alice.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;

public class HelloWorld implements Callable {

    public static void main(String[] args) {
        List<HelloWorld> list = new CopyOnWriteArrayList<HelloWorld>();

        java.lang.String str1 = null;
        str1 = "abc";

        String str = new String();
        str= "abc";
        System.out.println(str1 == str);





//        ClassPathXmlApplicationContext classPathXmlApplicationContext = null;
//        try {
//            classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
//            UserService userService = (UserService) classPathXmlApplicationContext.getBean("UserServiceImpl");
//            userService.addUser();
//        } catch (BeansException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
