package kr.co.greenuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BachelorController {

    @GetMapping("/bachelor_guide/bachelor_notice")
    public String bachelor_notice(){
        return "/bachelor_guide/bachelor_notice";
    }
    @GetMapping("/bachelor_guide/bachelor_schedule")
    public String bachelor_schedule(){
        return "/bachelor_guide/bachelor_schedule";
    }
    @GetMapping("/bachelor_guide/com_n_grd")
    public String com_n_grd(){
        return "/bachelor_guide/com_n_grd";
    }
    @GetMapping("/bachelor_guide/cou_reg")
    public String cou_reg(){
        return "/bachelor_guide/cou_reg";
    }
    @GetMapping("/bachelor_guide/fre_Que")
    public String fre_Que(){
        return "/bachelor_guide/fre_Que";
    }
    @GetMapping("/bachelor_guide/grade")
    public String grade(){
        return "/bachelor_guide/grade";
    }
}
