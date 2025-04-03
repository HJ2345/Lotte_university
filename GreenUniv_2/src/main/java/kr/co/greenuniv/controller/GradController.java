package kr.co.greenuniv.controller;

import kr.co.greenuniv.dto.GradDTO;
import kr.co.greenuniv.service.DeptService;
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
    public String Humanities_And_Social_Sciences(Model model) {
        List<GradDTO> gradDTOList = deptService.getDeptListByUnivName("인문사회대학");
        model.addAttribute("gradDTOList", gradDTOList);
        return "/grad_school/Humanities_And_Social_Sciences";
    }
    @GetMapping("/grad_school/Graduate_School")
    public String Graduate(Model model){
        List<GradDTO> gradDTOList = deptService.getDeptListByUnivName("대학원");
        model.addAttribute("gradDTOList", gradDTOList);
        return "/grad_school/Graduate_School";
    }
    @GetMapping("/grad_school/Engineering")
    public String Engineering(Model model){
        List<GradDTO> gradDTOList = deptService.getDeptListByUnivName("공과대학");
        model.addAttribute("gradDTOList", gradDTOList);
        return "/grad_school/Engineering";
    }
    @GetMapping("/grad_school/Education")
    public String Education(Model model){
        List<GradDTO> gradDTOList = deptService.getDeptListByUnivName("사범대학");
        model.addAttribute("gradDTOList", gradDTOList);
        return "/grad_school/Education";
    }
    @GetMapping("/grad_school/Natural_Sciences")
    public String Natural_Sciences(Model model){
        List<GradDTO> gradDTOList = deptService.getDeptListByUnivName("자연과학대학");
        model.addAttribute("gradDTOList", gradDTOList);
        return "/grad_school/Natural_Sciences";
    }
}
