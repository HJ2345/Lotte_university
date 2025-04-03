package kr.co.greenuniv.service;


import kr.co.greenuniv.dto.ProfessorDTO;
import kr.co.greenuniv.dto.ProfessorListDTO;
import kr.co.greenuniv.dto.UserDTO;
import kr.co.greenuniv.entity.Department;
import kr.co.greenuniv.entity.Professor;
import kr.co.greenuniv.entity.University;
import kr.co.greenuniv.entity.User;
import kr.co.greenuniv.repository.DeptRepository;
import kr.co.greenuniv.repository.ProfessorRepository;
import kr.co.greenuniv.repository.UnivRepository;
import kr.co.greenuniv.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final UnivRepository univRepository;
    private final DeptRepository deptRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public void regProfessor(ProfessorDTO professorDTO) {
        University university = univRepository.findById(professorDTO.getP_lesson())
                .orElseThrow(() -> new RuntimeException("University not found"));

        Department department = deptRepository.findByDeptNo(professorDTO.getP_spec2());
        if (department == null) {
            throw new RuntimeException("Department not found");
        }

        // 교수번호 생성
        String year = professorDTO.getP_appointdate().substring(0, 4);
        String prefix = year + department.getDeptNo(); // ex: 202401

        String latest = professorRepository.findMaxPNumWithPrefix("P" + prefix);
        int next = 1;
        if (latest != null) {
            String lastSeq = latest.substring(("P" + prefix).length());
            next = Integer.parseInt(lastSeq) + 1;
        }

        String newPnum = "P" + prefix + String.format("%02d", next); // ✅ 교수번호 완성 ex: P20240102

        // 🔹 아이디 & 비밀번호 설정 (해싱 없이 그대로 저장)
        String username = newPnum;
        String password = newPnum; // 교수번호 그대로 비밀번호로 사용

        // 매핑 및 저장
        Professor professor = modelMapper.map(professorDTO, Professor.class);
        professor.setP_num(newPnum);
        professor.setUniversity(university);
        professor.setDepartment(department);

        // 🔹 User 엔티티 생성 후 저장 (교수 계정 생성)
        User user = User.builder()
                .uid(username)
                .pass(password) // 교수번호 그대로 비밀번호로 저장
                .name(professorDTO.getP_name()) // 교수 이름
                .role("PROFESSOR") // 교수 역할 부여
                .build();

        userRepository.save(user); // 🔹 User 정보 저장

        log.info("등록된 교수 정보: 교수번호={}, 아이디={}, 비밀번호={}", newPnum, username, password);
    }


    public List<ProfessorListDTO> getProfessorList() {
        List<Professor> professors = professorRepository.findAll();
        List<ProfessorListDTO> list = new ArrayList<>();

        for (Professor p : professors) {
            list.add(new ProfessorListDTO(
                    p.getP_num(),
                    p.getP_name(),
                    p.getP_Pnum(),          // 주민번호
                    p.getP_hp(),
                    p.getP_email(),
                    p.getDepartment().getDeptName(),
                    "교수",                 // 직위 (더미)
                    "재직",                 // 재직 여부 (더미)
                    p.getP_appointdate()
            ));
        }

        return list;
    }

}

