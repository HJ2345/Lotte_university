package kr.co.greenuniv.service;


import kr.co.greenuniv.dto.StudentDTO;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final UnivRepository univRepository;
    private final DeptRepository deptRepository;
    private final ProfessorRepository professorRepository;
    private final ModelMapper modelMapper;

    public void register(StudentDTO studentDTO) {
        // 연관 엔티티 조회
        University university = univRepository.findById(studentDTO.getUnivName())
                .orElseThrow(() -> new RuntimeException("University not found"));

        Department department = deptRepository.findById(studentDTO.getDeptNo())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Professor professor = professorRepository.findById(studentDTO.getProfNo())
                .orElseThrow(() -> new RuntimeException("Professor not found"));

        // 학번 생성
        String year = String.valueOf(studentDTO.getAdmissionYear());
        String prefix = year + department.getDeptNo(); // ex) 202501

        String latestNum = studentRepository.findLatestStudentNum(prefix);
        int seq = 1;
        if (latestNum != null) {
            seq = Integer.parseInt(latestNum.substring(prefix.length())) + 1;
        }
        String S_num = prefix + String.format("%02d", seq);

        // 매핑 및 저장
        Student student = modelMapper.map(studentDTO, Student.class);
        student.setS_num(S_num);
        student.setUniversity(university);
        student.setDepartment(department);
        student.setProfessor(professor);

        studentRepository.save(student);

    }
}
