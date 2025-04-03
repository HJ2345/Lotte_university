package kr.co.greenuniv.service;

import kr.co.greenuniv.dto.DepartmentListDTO;
import kr.co.greenuniv.dto.DeptDTO;
import kr.co.greenuniv.dto.GradDTO;
import kr.co.greenuniv.entity.Department;
import kr.co.greenuniv.entity.University;
import kr.co.greenuniv.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeptService {

    private final DeptRepository deptRepository;
    private final UnivRepository univRepository;
    private final ModelMapper modelMapper;


    private final ProfessorRepository professorRepository; // 추가
    private final StudentRepository studentRepository;     // 학생 수용
    private final CourseRepository courseRepository;



    public void register(DeptDTO deptDTO) {
        // 학과 엔티티 변환
        Department dept = modelMapper.map(deptDTO, Department.class);

        // 학과장 이름 수동 설정 (중요)
        dept.setDeptChief(deptDTO.getDeptChief());

        // 학과 번호 생성
        String latestDeptNo = deptRepository.findTopDeptNo(); // ex: "03"
        log.info("latestDeptNo {}", latestDeptNo);

        int newNo = 1;
        if (latestDeptNo != null) {
            newNo = Integer.parseInt(latestDeptNo) + 1;
        }
        String generatedDeptNo = String.format("%02d", newNo);
        log.info("generatedDeptNo {}", generatedDeptNo);

        dept.setDeptNo(generatedDeptNo);

        // 단과대학 연결
        University university = univRepository.findById(deptDTO.getUnivName())
                .orElseThrow(() -> new RuntimeException("University not found"));
        dept.setUniversity(university);

        log.info("생성된 deptNo = {}", generatedDeptNo);

        log.info("저장할 학과 정보 = {}", dept);
        deptRepository.save(dept);
        log.info("생성된 deptNo = {}", generatedDeptNo);

    }

    public List<DepartmentListDTO> getDepartmentList() {
        List<Department> departments = deptRepository.findAll();
        List<DepartmentListDTO> list = new ArrayList<>();

        for (Department d : departments) {
            log.info(">>> 처리 중인 학과: {}, 학과장: {}", d.getDeptName(), d.getDeptChief());

            String deptChief = d.getDeptChief() != null ? d.getDeptChief() : "없음";

            int professorCount = professorRepository.countByDepartment_DeptNo(d.getDeptNo());
            int studentCount = studentRepository.countByDepartment_DeptNo(d.getDeptNo());
            int courseCount = courseRepository.countByDepartment_DeptNo(d.getDeptNo());
            log.info(">>> 교수 수: {}, 학생 수: {}, 강의 수: {}", professorCount, studentCount, courseCount);

            list.add(new DepartmentListDTO(
                    d.getDeptNo(),
                    d.getUniversity().getUnivName(),
                    d.getDeptName(),
                    deptChief,
                    d.getDeptHp(),
                    professorCount,
                    studentCount,
                    courseCount
            ));
        }
        log.info(">>> 최종 반환되는 학과 수: {}", list.size());

        return list;
    }


    public List<GradDTO> getDeptListByUnivName(String univName) {
        return deptRepository.findAll().stream()
                .filter(dept -> dept.getUniversity().getUnivName().equals(univName)) // 특정 대학명 필터링
                .map(dept -> new GradDTO(
                        dept.getDeptChief(),  // 학과장
                        dept.getDeptHp(),     // 학과 전화번호
                        dept.getDeptName(),   // 학과명
                        dept.getUniversity().getUnivName()    // 대학명
                ))
                .collect(Collectors.toList());
    }

}
