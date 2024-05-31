package com.simpletomate.simpletomatebackend.controllers;
import java.util.*;

import com.simpletomate.simpletomatebackend.models.Recipe;
import com.simpletomate.simpletomatebackend.repositories.SimpleTomateBackendApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
