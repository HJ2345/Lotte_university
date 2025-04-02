package kr.co.greenuniv.controller;


import kr.co.greenuniv.dto.CourseDTO;
import kr.co.greenuniv.dto.StudentDTO;
import kr.co.greenuniv.entity.Professor;
import kr.co.greenuniv.repository.DeptRepository;
import kr.co.greenuniv.repository.ProfessorRepository;
import kr.co.greenuniv.repository.UnivRepository;
import kr.co.greenuniv.service.CourseService;
import kr.co.greenuniv.dto.DeptDTO;
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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static java.rmi.server.LogStream.log;


@Slf4j
@Controller
@RequiredArgsConstructor
public class AdminController {

    private final UnivRepository univRepository;
    private final DeptRepository deptRepository;
    private final ProfessorRepository professorRepository;

    private final StudentService studentService;  // 학생등록 service
    private final UnivService univService;  // 학생등록 service
    private final DeptService deptService;  // 학생등록 service

    @Autowired
    private CourseService courseService;
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

    @GetMapping("admin/lecEnrollment")  // 강의 등록
    public String lecEnrollment(Model model){
        model.addAttribute("courseDto", new CourseDTO());
        return "admin/lecEnrollment";
    }

    @PostMapping("admin/lecEnrollment")
    public String lecEnrollment(@ModelAttribute("courseDto") CourseDTO courseDto){
        courseService.save(courseDto);

        return "redirect:/admin/lecEnrollment";
    }


    @GetMapping("admin/lectureList")
    public String lectureList(){
        return "admin/lectureList";
    }

    @GetMapping("/admin/profEnrollment")
    public String profEnrollment(Model model){
        model.addAttribute("professorDto" , new ProfessorDTO());
        model.addAttribute("univList", univRepository.findAll());
        model.addAttribute("deptList", deptRepository.findAll());


        return "admin/profEnrollment";
    }

    @PostMapping("/admin/profEnrollment")
    public String regProfEnrollment(@ModelAttribute ProfessorDTO professorDTO){

        log.info("📌 전달받은 ProfessorDTO = {}", professorDTO);

        professorService.regProfessor(professorDTO);




        return "redirect:/admin/profEnrollment";
    }

    @GetMapping("admin/stdEnrollment")
    public String stdEnrollment(Model model){
        model.addAttribute("univList", univRepository.findAll());
        model.addAttribute("deptList", deptRepository.findAll());
        model.addAttribute("profList", professorRepository.findAll());
        model.addAttribute("studentDTO", new StudentDTO());
        return "admin/stdEnrollment";
    }

    @PostMapping("/admin/stdEnrollment")
    public String savestdEnrollment(@ModelAttribute StudentDTO studentDto) {


        studentService.register(studentDto);
        return "redirect:/admin/stdEnrollment";
    }


    @GetMapping("admin/studentList")
    public String studentList(){
        return "admin/studentList";
    }

    @GetMapping("admin/univDeptEnrollment")
    public String univDeptEnrollment(Model model) {
        List<University> univList = univService.findAll();
        List<Professor> profList = professorRepository.findAll();

        model.addAttribute("univList", univList);
        model.addAttribute("profList", profList); // 전체 교수 목록 전달
        model.addAttribute("univList", univRepository.findAll());
        model.addAttribute("p_numList", professorRepository.findAll());

        // 로그 찍기
        profList.forEach(prof -> {
            log.info("교수 이름: {}", prof.getP_name());
            if (prof.getUniversity() != null) {
                log.info("소속 대학: {}", prof.getUniversity().getUnivName());
            } else {
                log.warn("소속 대학 없음!");
            }
        });


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
