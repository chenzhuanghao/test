package com.czh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/hello")
public class HelloController {
    @RequestMapping(value="/world",method=RequestMethod.GET)
    public String hello(Model model){
    	System.out.println("444444444444444444444");
        model.addAttribute("msg", "ÄãºÃspring mvc");
        return "index";
    }
}
