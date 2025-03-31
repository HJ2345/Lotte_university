package kr.co.greenuniv.controller;

import kr.co.greenuniv.dto.DeptDTO;
import kr.co.greenuniv.dto.StudentDTO;
import kr.co.greenuniv.dto.UnivDTO;
import kr.co.greenuniv.entity.University;
import kr.co.greenuniv.service.DeptService;
import kr.co.greenuniv.dto.ProfessorDTO;
import kr.co.greenuniv.service.ProfessorService;
import kr.co.greenuniv.service.StudentService;
import kr.co.greenuniv.service.UnivService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static java.rmi.server.LogStream.log;


@Slf4j
@Controller
@RequiredArgsConstructor
public class AdminController {


    private final StudentService studentService;  // 학생등록 service
    private final UnivService univService;  // 학생등록 service
    private final DeptService deptService;  // 학생등록 service
    @Autowired
    private ProfessorService professorService;


    @GetMapping("admin/adminMain")
    public String index(){
        return "admin/adminMain";
    }

    @GetMapping("admin/courseStatus")
    public String courseStatus(){
        return "admin/courseStatus";
    }

    @GetMapping("admin/departmentList")
    public String deptList(){
        return "admin/departmentList";
    }

    @GetMapping("admin/eduStatus")
    public String eduStatus(){
        return "admin/eduStatus";
    }

    @GetMapping("admin/facultyList")
    public String facultyList(){
        return "admin/facultyList";
    }

    @GetMapping("admin/lecEnrollment")
    public String lecEnrollment(){
        return "admin/lecEnrollment";
    }

    @GetMapping("admin/lectureList")
    public String lectureList(){
        return "admin/lectureList";
    }

    @GetMapping("/admin/profEnrollment")
    public String profEnrollment(Model model){
        model.addAttribute("professorDto" , new ProfessorDTO());
        return "admin/profEnrollment";
    }

    @PostMapping("/admin/profEnrollment")
    public String regProfEnrollment(@ModelAttribute ProfessorDTO professorDTO){
        professorService.regProfessor(professorDTO);
        return "redirect:/admin/profEnrollment";
    }

    @GetMapping("admin/stdEnrollment")
    public String stdEnrollment(Model model){
        model.addAttribute("studentDto", new StudentDTO());
        return "admin/stdEnrollment";
    }

    @PostMapping("/admin/stdEnrollment")
    public String savestdEnrollment(@ModelAttribute StudentDTO studentDto) {


        log.info("입학구분: {}", studentDto.getAdmissionType());
        log.info("입학학기: {}", studentDto.getAdmissionGrade());
        log.info("입학학년: {}", studentDto.getAdmissionSemester());


        studentService.save(studentDto);


        return "redirect:/admin/stdEnrollment";
    }


    @GetMapping("admin/studentList")
    public String studentList(){
        return "admin/studentList";
    }

    @GetMapping("admin/univDeptEnrollment")
    public String univDeptEnrollment(Model model) {
        List<University> univList = univService.findAll();
        model.addAttribute("univList", univList);
        return "admin/univDeptEnrollment";
    }

    @PostMapping("/admin/univDeptEnrollment")
    public String univSave(UnivDTO univDTO) {

        log.info("univDTO {}", univDTO);
        univService.register(univDTO);

        return "redirect:/admin/univDeptEnrollment";
    }

    @PostMapping("/admin/univDeptEnrollment2")
    public String deptSave(DeptDTO deptDTO) {

        log.info("deptDTO {}", deptDTO);
        deptService.register(deptDTO);

        return "redirect:/admin/univDeptEnrollment";
    }
}
