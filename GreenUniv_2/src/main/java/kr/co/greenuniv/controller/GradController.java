package kr.co.greenuniv.controller;

import kr.co.greenuniv.dto.GradDTO;
import kr.co.greenuniv.service.DeptService;
import kr.co.greenuniv.service.GradService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GradController {

    private final DeptService deptService;

    public GradController(DeptService deptService) {
        this.deptService = deptService;
    }

    @GetMapping("/grad_school/Humanities_And_Social_Sciences")
    public String Humanities(Model model){
        List<GradDTO> gradDTOList = GradService.findByunivname();
        model.addAttribute("gradDTOList",gradDTOList);
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
