package kr.co.greenuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testcon {

    @GetMapping("/col_intro/edu_phil")
    public String test1() {

        return "/col_intro/edu_phil";
    }
}
