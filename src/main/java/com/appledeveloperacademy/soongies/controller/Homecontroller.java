package com.appledeveloperacademy.soongies.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Homecontroller {

    @Value("${app.version:1.0.0}")
    String version;

    @GetMapping("/")
    public String home() {
        return "Hello CI/CD! version: " + version;
    }

    @GetMapping("/liver")
    public String getLiverNickname() {
        return "My name is Liver";
    }

    @PostMapping("/")
    public String getNickname(
            @RequestParam String nickname
    ) {
        return "My name is" + nickname;
    }

}
