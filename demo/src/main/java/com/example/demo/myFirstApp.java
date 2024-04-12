package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myFirstApp {
    @RequestMapping("/hello")
    public String sayHello()
    {
        return "Hello World kgjkfjk";
    }
    @RequestMapping("/hello{name}")
    public String printByName(@PathVariable("name") String pathvar)
    {
        return "Hello " + pathvar;
    }

}

