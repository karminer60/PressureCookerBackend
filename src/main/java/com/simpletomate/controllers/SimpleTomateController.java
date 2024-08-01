package com.simpletomate.controllers;

import com.simpletomate.SimpleTomateBackendApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleTomateController {

    @Autowired
    SimpleTomateBackendApplication reciperepos;
    // http://localhost:2019/total

    @RestController
    public class HelloWorldController {

        @GetMapping("/sayhello")
        public String sayHelloWorld(){
            return "Hello World!";
        }

    }
}
