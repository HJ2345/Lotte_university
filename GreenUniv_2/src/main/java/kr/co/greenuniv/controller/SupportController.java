package kr.co.greenuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupportController {

    @GetMapping("/support/lectureRegister")
    public String lectureRegister() {
        return "support/lectureRegister";
    }

}
