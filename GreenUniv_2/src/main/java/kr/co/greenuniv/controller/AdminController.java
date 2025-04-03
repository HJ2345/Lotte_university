package kr.co.greenuniv.controller;


import kr.co.greenuniv.dto.*;
import kr.co.greenuniv.entity.Course;
import kr.co.greenuniv.entity.Department;
import kr.co.greenuniv.entity.Professor;
import kr.co.greenuniv.repository.*;
import kr.co.greenuniv.service.CourseService;
import kr.co.greenuniv.entity.University;
import kr.co.greenuniv.service.DeptService;
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


@Slf4j
@Controller
@RequiredArgsConstructor
public class AdminController {

    private final UnivRepository univRepository;
    private final DeptRepository deptRepository;
    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;



    private final StudentService studentService;  // 학생등록 service
    private final UnivService univService;  // 학생등록 service
    private final DeptService deptService;  // 학생등록 service

    @Autowired
    private CourseService courseService;
    @Autowired
    private ProfessorService professorService;



    @GetMapping("/admin/adminMain")
    public String adminMain(Model model) {
        AdminStatDTO stats = AdminStatDTO.builder()
                .departmentCount(deptRepository.count())
                .courseCount(courseRepository.count())
                .professorCount(professorRepository.count())
                .staffCount(24L) // 더미
                .studentCount(studentRepository.countByStatus("재학")) // 재학생만 집계
                .leaveCount(studentRepository.countByStatus("휴학"))
                .graduateSchoolCount(studentRepository.countByStatus("대학원"))
                .graduateCount(studentRepository.countByStatus("졸업"))
                .build();


        List<StudentDeptStatDTO> deptStats = studentService.getStatsByDepartmentWithTotal();
        List<Course> courseList = courseRepository.findAll(); // 강의 목록
        List<StudentGradeStatDTO> gradeStats = studentService.getStatsByGradeWithTotal();


        model.addAttribute("courseList", courseList);
        model.addAttribute("stats", stats);
        model.addAttribute("gradeStats", gradeStats); // 💡 새로 추가된 통계
        model.addAttribute("deptStats", deptStats);
        return "/admin/adminMain";
    }

    @GetMapping("admin/courseStatus")
    public String courseStatus(){
        return "/admin/courseStatus";
    }

    @GetMapping("admin/departmentList")
    public String deptList(Model model) {

        List<DepartmentListDTO> departmentList = deptService.getDepartmentList();
        log.info(">>> 전달되는 학과 목록 수: {}", departmentList.size());
        model.addAttribute("departmentList", departmentList);


        return "/admin/departmentList";
    }

    @GetMapping("admin/eduStatus")
    public String eduStatus(Model model){

        List<EduStatusDTO> eduStatusList = courseService.getEduStatusList();
        model.addAttribute("eduStatusList", eduStatusList);



        return "/admin/eduStatus";
    }

    @GetMapping("admin/facultyList")
    public String facultyList(Model model){


        List<ProfessorListDTO> professorList = professorService.getProfessorList();
        model.addAttribute("professorList", professorList);


        return "/admin/facultyList";
    }

    @GetMapping("admin/lecEnrollment")
    public String lecEnrollment(Model model) {
        model.addAttribute("courseDto", new CourseDTO());

        // ✅ 여기에 대학 리스트랑 학과 리스트도 넘겨줘야 함
        List<University> univList = univRepository.findAll();
        List<Department> deptList = deptRepository.findAll();

        model.addAttribute("univList", univList);
        model.addAttribute("deptList", deptList);

        return "/admin/lecEnrollment";
    }

    @PostMapping("admin/lecEnrollment")
    public String lecEnrollment(@ModelAttribute("courseDto") CourseDTO courseDto){
        courseService.save(courseDto);

        return "redirect:/admin/lecEnrollment";
    }


    @GetMapping("admin/lectureList")
    public String lectureList(Model model) {


        List<lectureListDTO> lectureList = courseService.getAllCourses();
        model.addAttribute("lectureList", lectureList);



        return "/admin/lectureList";
    }

    @GetMapping("/admin/profEnrollment")
    public String profEnrollment(Model model){
        model.addAttribute("professorDto" , new ProfessorDTO());
        model.addAttribute("univList", univRepository.findAll());
        model.addAttribute("deptList", deptRepository.findAll());


        return "/admin/profEnrollment";
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
        return "/admin/stdEnrollment";
    }

    @PostMapping("/admin/stdEnrollment")
    public String savestdEnrollment(@ModelAttribute StudentDTO studentDto) {


        studentService.register(studentDto);
        return "redirect:/admin/stdEnrollment";
    }


    @GetMapping("admin/studentList")
    public String studentList(Model model) {


        List<StudentListDTO> studentList = studentService.getStudentList();
        model.addAttribute("studentList", studentList);

        return "/admin/studentList";
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


        return "/admin/univDeptEnrollment";
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
