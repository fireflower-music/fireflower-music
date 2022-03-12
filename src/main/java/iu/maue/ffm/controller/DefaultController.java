package iu.maue.ffm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/hello")
public class DefaultController {

    @GetMapping("")
    public String sayHello(){
        return "Welcome FireFlower Music!!";
    }
}
