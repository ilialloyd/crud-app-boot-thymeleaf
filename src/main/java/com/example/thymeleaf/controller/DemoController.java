package com.example.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class DemoController {

    //create a mapping for "/hello"
    @GetMapping("/hello")
    public String getHello(Model model){

        //add attribute to the model
                                                //attribute itself
        model.addAttribute("theDate",new Date());

        return "helloworld";
    }
}
