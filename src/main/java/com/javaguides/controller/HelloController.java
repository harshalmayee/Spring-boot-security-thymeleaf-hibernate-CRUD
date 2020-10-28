package com.javaguides.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public final Logger log= LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello")
    public String hello(){
        log.debug("This is a debug message");
        log.info("This is a info message");
        log.warn("This is a warning message");
        log.error("This is a Error message");
        return "Hello World!";
    }
}
