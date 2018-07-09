package com.ccj.homework.homeworktest2.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/test")
    public String say() {
        return "HELLO";
    }
}
