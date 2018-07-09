package com.ccj.homework.homeworktest2.other;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class otherPath {
    @GetMapping("/other")
    public String otherpath() {
        return "Hello";
    }
}
