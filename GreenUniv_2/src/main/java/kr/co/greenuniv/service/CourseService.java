package kr.co.greenuniv.service;

import kr.co.greenuniv.dto.CourseDTO;
import kr.co.greenuniv.dto.lectureListDTO;
import kr.co.greenuniv.dto.EduStatusDTO;
import kr.co.greenuniv.entity.Course;
import kr.co.greenuniv.entity.Department;
import kr.co.greenuniv.entity.University;
import kr.co.greenuniv.repository.CourseRepository;
import kr.co.greenuniv.repository.DeptRepository;
import kr.co.greenuniv.repository.UnivRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final UnivRepository univRepository;
    private final DeptRepository deptRepository;
    private final ModelMapper modelMapper;

    public void save(CourseDTO courseDto) {
        log.info(">>> 저장될 DTO: {}", courseDto);

        // 외래키 조회
        University university = univRepository.findById(courseDto.getUnivName())
                .orElseThrow(() -> new RuntimeException("대학 정보가 없습니다"));
        Department department = deptRepository.findById(courseDto.getDeptNo())
                .orElseThrow(() -> new RuntimeException("학과 정보가 없습니다"));

        // 과목 코드 생성
        String year = String.valueOf(LocalDate.now().getYear()); // ex: 2025
        String deptCode = department.getDeptNo(); // ex: 01
        String semester = courseDto.getSemester(); // ex: 1학기

        String prefix = deptCode + year + semester; // ex: 0120251학기

        // 현재 prefix로 시작하는 최대 코드 조회
        String latestCode = courseRepository.findMaxCorCodeWithPrefix(prefix);
        int nextSeq = 1;
        if (latestCode != null && latestCode.length() > prefix.length()) {
            String lastSeq = latestCode.substring(prefix.length());
            nextSeq = Integer.parseInt(lastSeq) + 1;
        }
        String newCorCode = prefix + String.format("%02d", nextSeq); // ex: 0120251학기01

        // 엔티티 저장
        Course course = modelMapper.map(courseDto, Course.class);
        course.setCor_code(newCorCode);
        course.setUniversity(university);
        course.setDepartment(department);

        courseRepository.save(course);
    }

    public List<EduStatusDTO> getEduStatusList() {
        List<Course> courseList = courseRepository.findAll();
        List<EduStatusDTO> result = new ArrayList<>();

        for (Course c : courseList) {
            EduStatusDTO dto = new EduStatusDTO(
                    c.getDepartment().getDeptName(),
                    c.getCor_code(),
                    c.getCor_lecName(),
                    c.getCor_grade(),
                    c.getCor_professor(),
                    c.getCor_type(),
                    c.getCor_point(),
                    c.getCor_class(),
                    Integer.parseInt(c.getCor_maxEnrolment()),  // 수강인원
                    Math.random() * 100                        // 수강률 (더미)
            );
            result.add(dto);
        }

        return result;
    }



    public List<lectureListDTO> getAllCourses() {
        List<Course> lectureList = courseRepository.findAll();
        List<lectureListDTO> dtoList = new ArrayList<>();

        for (Course course : lectureList) {
            dtoList.add(new lectureListDTO(
                    course.getCor_code(),
                    course.getDepartment().getDeptName(),
                    course.getCor_grade(),
                    course.getCor_type(),
                    course.getCor_lecName(),
                    course.getCor_professor(),
                    course.getCor_point(),
                    course.getLectureDays() + " / " + course.getStartTime() + "~" + course.getEndTime(),
                    course.getCor_class(),
                    course.getCor_maxEnrolment()
            ));
        }

        return dtoList;
    }



}
