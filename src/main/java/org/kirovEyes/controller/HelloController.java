package org.kirovEyes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;

@RestController
public class HelloController {

    @Autowired
    private DemoController demoController;

    @GetMapping("/hello")
    public String hello(String text) {
        System.out.println("hello springboot!!!");
        demoController.changeLabel(text);
        return "hello springboot";
    }


}
