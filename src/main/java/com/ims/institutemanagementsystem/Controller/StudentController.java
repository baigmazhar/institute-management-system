package com.ims.institutemanagementsystem.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/test")
    public  String testMethod(){
        return "Working";
    }
}
