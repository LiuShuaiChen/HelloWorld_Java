package com.alice.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class controller {

    private int count;

    private ArrayList<Student> studentArrayList = new ArrayList<Student>();

    @RequestMapping("/")
    String home() {
        int temp = count++;
        Student student = new Student();
        student.setId(temp);
        student.setName("Alice_" + temp);
        student.setAddress("Beijing_" + temp);
        studentArrayList.add(student);
        System.out.println(student.toString());
        return "Hello World == > " + studentArrayList.size();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(controller.class, args);
    }
}
