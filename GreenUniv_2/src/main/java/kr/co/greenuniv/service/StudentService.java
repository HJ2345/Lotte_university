package kr.co.greenuniv.service;

import kr.co.greenuniv.dto.StudentDTO;
import kr.co.greenuniv.dto.StudentDeptStatDTO;
import kr.co.greenuniv.dto.StudentGradeStatDTO;
import kr.co.greenuniv.dto.StudentListDTO;
import kr.co.greenuniv.entity.Department;
import kr.co.greenuniv.entity.Professor;
import kr.co.greenuniv.entity.Student;
import kr.co.greenuniv.entity.University;
import kr.co.greenuniv.repository.DeptRepository;
import kr.co.greenuniv.repository.ProfessorRepository;
import kr.co.greenuniv.repository.StudentRepository;
import kr.co.greenuniv.repository.UnivRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final UnivRepository univRepository;
    private final DeptRepository deptRepository;
    private final ProfessorRepository professorRepository;
    private final ModelMapper modelMapper;

    /**
     * ✅ 학생 등록
     */
    public void register(StudentDTO studentDTO) {
        // 1. 연관 엔티티 조회
        University university = univRepository.findById(studentDTO.getUnivName())
                .orElseThrow(() -> new RuntimeException("University not found"));
        Department department = deptRepository.findById(studentDTO.getDeptNo())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        Professor professor = professorRepository.findById(studentDTO.getProfNo())
                .orElseThrow(() -> new RuntimeException("Professor not found"));

        // 2. 학번 생성: S + 연도 + 학과코드 + 2자리 순번
        String year = String.valueOf(studentDTO.getAdmissionYear());
        String prefix = "S" + year + department.getDeptNo(); // 예: S202403
        String latestNum = studentRepository.findLatestStudentNum(prefix); // 마지막 학번 조회

        int seq = 1;
        if (latestNum != null) {
            String lastSeqStr = latestNum.substring(prefix.length());
            seq = Integer.parseInt(lastSeqStr) + 1;
        }
        String S_num = prefix + String.format("%02d", seq); // 예: S20240303

        // 3. DTO → Entity 매핑
        Student student = modelMapper.map(studentDTO, Student.class);
        student.setS_num(S_num);
        student.setUniversity(university);
        student.setDepartment(department);
        student.setProfessor(professor);
        student.setStatus(studentDTO.getStatus());

        // 4. 저장
        studentRepository.save(student);
        log.info(">>> 최종 학번: {}", student.getS_num());
    }

    /**
     * ✅ 학년별 재학생/휴학생/전체 + 총합 통계
     */
    public List<StudentGradeStatDTO> getStatsByGradeWithTotal() {
        String[] grades = {"1학년", "2학년", "3학년", "4학년"};
        List<StudentGradeStatDTO> list = new ArrayList<>();

        long totalEnrolled = 0;
        long totalLeave = 0;

        for (String grade : grades) {
            long enrolled = studentRepository.countByAdmissionGradeAndStatus(grade, "재학");
            long leave = studentRepository.countByAdmissionGradeAndStatus(grade, "휴학");

            totalEnrolled += enrolled;
            totalLeave += leave;

            list.add(new StudentGradeStatDTO(
                    grade,
                    enrolled,
                    leave,
                    enrolled + leave
            ));
        }

        // ✅ 맨 마지막에 총합 row 추가
        list.add(new StudentGradeStatDTO(
                "총합",
                totalEnrolled,
                totalLeave,
                totalEnrolled + totalLeave
        ));

        return list;
    }


    public List<StudentDeptStatDTO> getStatsByDepartmentWithTotal() {
        List<Department> departments = deptRepository.findAll();
        List<StudentDeptStatDTO> list = new ArrayList<>();

        long totalEnrolled = 0;
        long totalLeave = 0;

        for (Department dept : departments) {
            String deptNo = dept.getDeptNo();
            String deptName = dept.getDeptName();

            long enrolled = studentRepository.countByDepartment_DeptNoAndStatus(deptNo, "재학");
            long leave = studentRepository.countByDepartment_DeptNoAndStatus(deptNo, "휴학");

            totalEnrolled += enrolled;
            totalLeave += leave;

            list.add(new StudentDeptStatDTO(
                    deptName,
                    enrolled,
                    leave,
                    enrolled + leave
            ));
        }

        // ✅ 총합 라인 추가
        list.add(new StudentDeptStatDTO(
                "총합",
                totalEnrolled,
                totalLeave,
                totalEnrolled + totalLeave
        ));

        return list;
    }

    public List<StudentListDTO> getStudentList() {
        List<Student> students = studentRepository.findAll();
        List<StudentListDTO> list = new ArrayList<>();

        for (Student s : students) {
            list.add(new StudentListDTO(
                    s.getS_num(),                           // 학번
                    s.getS_name(),                          // 이름
                    s.getS_residentId(),                    // 주민번호
                    s.getS_hp(),                            // 휴대폰
                    s.getS_email(),                         // 이메일
                    s.getDepartment().getDeptName(),        // 학과
                    s.getAdmissionGrade(),                  // 학년
                    s.getAdmissionSemester(),               // 학기
                    s.getStatus()                           // 상태
            ));
        }

        return list;
    }



}