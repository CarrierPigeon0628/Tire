package com.tire.tire.controller;

import com.tire.tire.service.TireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

public class TireController {

    @Autowired
    TireService tireService;

    @GetMapping("/tire/test/")
    public Map<String, Object> getTireTest() {
        return tireService.getTireTest();
    }
}
