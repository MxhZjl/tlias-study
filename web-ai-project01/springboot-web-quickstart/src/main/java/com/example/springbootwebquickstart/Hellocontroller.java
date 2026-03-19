package com.example.springbootwebquickstart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {
    @RequestMapping("/abcd")
    public String hello(String name) {
        System.out.println("name:" + name);
        return name+"Hello World!";
    }

}
