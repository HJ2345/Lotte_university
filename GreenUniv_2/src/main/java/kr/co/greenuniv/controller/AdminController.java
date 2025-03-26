package kr.co.greenuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

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

    @GetMapping("admin/profEnrollment")
    public String profEnrollment(){
        return "admin/profEnrollment";
    }

    @GetMapping("admin/stdEnrollment")
    public String stdEnrollment(){
        return "admin/stdEnrollment";
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
