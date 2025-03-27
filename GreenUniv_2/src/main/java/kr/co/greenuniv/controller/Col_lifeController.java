package kr.co.greenuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Col_lifeController {

    @GetMapping("/col_life/gallery")
    public String gallery(){

        return "/col_life/gallery";
    }

    @GetMapping("/col_life/meal_schedule")
    public String meal_schedule(){

        return "/col_life/meal_schedule";
    }

    @GetMapping("/col_life/std_council")
    public String std_council(){

        return "/col_life/std_council";
    }

    @GetMapping("/col_life/study")
    public String study(){

        return "/col_life/study";
    }

}