package com.example.shopcrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/hello")
    public String SayHelloCustomer(){
        return "Say Hello Customer!";
    }
    @GetMapping("/Thank")
    public String ThankYouForBought(){
        return "Thank You For Bought!";
    }
}
