package kr.co.greenuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradController {

    @GetMapping("/grad_school/Humanities_And_Social_Sciences")
    public String Humanities(){
        return "/grad_school/Humanities_And_Social_Sciences";
    }
    @GetMapping("/grad_school/Graduate_School")
    public String Graduate(){
        return "/grad_school/Graduate_School";
    }
    @GetMapping("/grad_school/Engineering")
    public String Engineering(){
        return "/grad_school/Engineering";
    }
    @GetMapping("/grad_school/Education")
    public String Education(){
        return "/grad_school/Education";
    }
    @GetMapping("/grad_school/Natural_Sciences")
    public String Natural_Sciences(){
        return "/grad_school/Natural_Sciences";
    }
}
