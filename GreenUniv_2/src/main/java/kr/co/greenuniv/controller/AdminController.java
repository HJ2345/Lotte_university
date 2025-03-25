package kr.co.greenuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/adminMain")
    public String index(){
        return "/admin/adminMain";
    }
}
