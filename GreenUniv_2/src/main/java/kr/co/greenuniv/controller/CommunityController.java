package kr.co.greenuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityController {

    @GetMapping("/community/freeBoardWrite")
    public String CommunityController() {
        return "/community/freeBoardWrite";
    }
}
