package kr.co.greenuniv.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnteranceGuide {

    @GetMapping("enterance_guide/consult")
    public String enteranceGuide(){
        return "/enterance_guide/consult";
    }

    @GetMapping("enterance_guide/early")
    public String early(){
        return "/enterance_guide/early";
    }

    @GetMapping("enterance_guide/notice")
    public String notice(){
        return "/enterance_guide/notice";
    }

    @GetMapping("enterance_guide/regular")
    public String regular(){
        return "/enterance_guide/regular";
    }

    @GetMapping("enterance_guide/transfer")
    public String transfer(){
        return "/enterance_guide/transfer";
    }

}
