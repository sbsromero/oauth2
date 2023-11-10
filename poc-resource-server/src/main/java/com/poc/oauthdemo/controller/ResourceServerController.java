package com.poc.oauthdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ResourceServerController {

    @GetMapping("/resources")
    public String[] test(Principal principal) {
        System.out.println("hello " + principal.getName());
        return new String[]{"resource1", "resource2", "resource3"};
    }
}
