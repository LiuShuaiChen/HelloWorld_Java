package com.alice.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class controller {

    private int count;

    @RequestMapping("/")
    String home() {
        int temp = count++;
        System.out.println(temp);
        return "Hello World == > " + temp;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(controller.class, args);
    }
}
