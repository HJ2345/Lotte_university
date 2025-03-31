package kr.co.greenuniv.controller;

import kr.co.greenuniv.dto.CourseDTO;
import kr.co.greenuniv.dto.StudentDTO;
import kr.co.greenuniv.service.CourseService;
import kr.co.greenuniv.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static java.rmi.server.LogStream.log;


@Slf4j
@Controller
public class AdminController {

    @Autowired
    private StudentService studentService;  // 학생등록 service
    @Autowired
    private CourseService courseService;


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

    @GetMapping("admin/profEnrollment")
    public String profEnrollment(){
        return "admin/profEnrollment";
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
    public String univDeptEnrollment(){
        return "admin/univDeptEnrollment";
    }
}
