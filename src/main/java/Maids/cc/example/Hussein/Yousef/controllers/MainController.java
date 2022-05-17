package Maids.cc.example.Hussein.Yousef.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class MainController {

    @GetMapping
    String index() {
        return "Hello from Maids.CC UAE !";
    }

}