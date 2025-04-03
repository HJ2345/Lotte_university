package kr.co.greenuniv.service;


import kr.co.greenuniv.dto.ProfessorDTO;
import kr.co.greenuniv.entity.Department;
import kr.co.greenuniv.entity.Professor;
import kr.co.greenuniv.entity.University;
import kr.co.greenuniv.repository.DeptRepository;
import kr.co.greenuniv.repository.ProfessorRepository;
import kr.co.greenuniv.repository.UnivRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final UnivRepository univRepository;
    private final DeptRepository deptRepository;
    private final ModelMapper modelMapper;

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

        // 매핑 및 저장
        Professor professor = modelMapper.map(professorDTO, Professor.class);
        professor.setP_num(newPnum);
        professor.setUniversity(university);
        professor.setDepartment(department);

        log.info("등록된 교수 정보: {}", professor);
        professorRepository.save(professor);
    }

}

