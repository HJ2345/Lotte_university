package kr.co.greenuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SupportController {

    @GetMapping("/support/curriculum")
    public String curriculum() {
        return "/support/curriculum";
    }

    @GetMapping("/support/gradeLookUp")
    public String gradeLookUp() {
        return "/support/gradeLookUp";
    }

    @GetMapping("/support/lectureRegister")
    public String lectureRegister() {
        return "/support/lectureRegister";
    }

    @GetMapping("/support/lectureRegList")
    public String lectureRegList() {
        return "/support/lectureRegList";
    }

    @GetMapping("/support/studentRecord")
    public String studentRecord() {
        return "/support/studentRecord";
    }
}
