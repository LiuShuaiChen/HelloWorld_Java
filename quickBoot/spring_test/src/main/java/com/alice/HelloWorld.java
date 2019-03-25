package com.alice;


import com.alice.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = null;
        try {
            classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
            UserService userService =(UserService)classPathXmlApplicationContext.getBean("UserServiceImpl");
            userService.addUser();
        } catch (BeansException e) {
            e.printStackTrace();
        }

    }
}
