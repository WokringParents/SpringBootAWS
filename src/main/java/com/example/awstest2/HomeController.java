package com.example.awstest2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "This is Home Page";
    }

    @RequestMapping("/bombom")
    public String bombom(){
        return "This is my BomBOom";
    }
}
