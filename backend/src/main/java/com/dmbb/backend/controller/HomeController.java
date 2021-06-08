package com.dmbb.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/home")
@CrossOrigin
public class HomeController {

    private static Integer counter = 0;

    @GetMapping
    public Map<String, String> test() {
        String res = "Test response from server: " + counter++;
        Map<String, String> map = new HashMap<>();
        map.put("data", res);
        return map;
    }

}
