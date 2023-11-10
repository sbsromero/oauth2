package com.example.oauthdemo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class WebClienteController {

    private final WebClient webClient;

    @Autowired
    public WebClienteController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/webclient")
    public String test2() {
        return webClient
          .get()
          .uri("http://localhost:8090/resources")
          .attributes(ServerOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId("myoauth2"))
          .retrieve()
          .bodyToMono(String.class)
          .map(s -> "data received: " + s)
          .block();
    }

    @GetMapping("/google")
    public String testGoogle() {
        return webClient
          .get()
          .uri("http://localhost:8090/resources")
          .attributes(ServerOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId("google"))
          .retrieve()
          .bodyToMono(String.class)
          .map(s -> "data received: " + s)
          .block();
    }

    @GetMapping("/")
    public String welcome() {
        return "welcome! ";
    }
}
