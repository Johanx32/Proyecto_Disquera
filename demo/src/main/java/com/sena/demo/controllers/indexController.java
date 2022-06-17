package com.sena.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping
public class indexController {

    @GetMapping(path = {"/","","/index"})
    
    public ModelAndView index(ModelAndView modelview){
        modelview.addObject("msn", "Este mensaje viene del controlador");
        modelview.setViewName("index");
        return modelview;
    }

    @GetMapping("/home")

    public String genero(){
        return "forward:/genero";
    }
 
    @GetMapping("/homee")

    public String disquera(){
        return "forward:/disquera";
    }

}
