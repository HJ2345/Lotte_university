package kr.co.greenuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WriteController {

    @GetMapping("/community/CommunityWrite")
    public String info() {
        return "community/CommunityWrite";
    }

}
