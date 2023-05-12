package com.example.greetservice.controller;

import com.example.greetservice.model.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    ResponseEntity<Greeting> greet(@RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting greeting = new Greeting();
        greeting.setId(counter.incrementAndGet());
        greeting.setMessage(String.format(template, name));
        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }
}
