package com.example.demo.controller;

import com.example.demo.service.ServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @Autowired
    private ServiceInterface service;

    @RequestMapping({ "/", "" })
    public String showCalculationResult(Model model) {
        int a = 10;
        int b = 20;
        int result = service.calculate(a, b);
        model.addAttribute("result", result);
        return "resultView";

    }
}