package kr.co.greenuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CollegeIntroController {

    @GetMapping("col_intro/pdt_greeting")
    public String pdtGreeting(){
        return "/col_intro/pdt_greeting";
    }

    @GetMapping("col_intro/organization")
    public String organization(){
        return "/col_intro/organization";
    }

    @GetMapping("col_intro/map")
    public String map(){
        return "/col_intro/map";
    }

    @GetMapping("col_intro/history")
    public String history(){
        return "/col_intro/history";
    }

    @GetMapping("col_intro/edu_phil")
    public String eduPhil(){
        return "/col_intro/edu_phil";
    }


}
