package com.example.oauthdemo2.controller;

import com.example.oauthdemo2.WelcomeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebClienteController {

    //private final WebClient webClient;

    private final WelcomeClient webClient;

    @Autowired
    public WebClienteController(WelcomeClient webClient) {
        this.webClient = webClient;
    }

    //@GetMapping("/webclient")
    /*public String test() {
        webClient.get()
          .uri("http://127.0.0.1:8090/resources")
          //.attributes()
          .retrieve()
          .bodyToMono(String.class)
          .subscribe(System.out::println);
        return "webclient module";
    }*/

    @GetMapping("/webclient")
    public String[] test2() {
        String[] welcome = webClient.getWelcome();
        return welcome;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome! ";
    }
}
