package kr.co.greenuniv.service;


import kr.co.greenuniv.dto.ProfessorDTO;
import kr.co.greenuniv.entity.Professor;
import kr.co.greenuniv.repository.ProfessorRepository;
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
    //private final DeptRepository deptRepository;
    private final ModelMapper modelMapper;

    public void regProfessor(ProfessorDTO professorDTO){

        // 교수번호 생성
        String professorId = generateProfessorId(professorDTO);
        professorDTO.setP_num(professorId);

        // DTO -> 엔티티 변환
        Professor professor = modelMapper.map(professorDTO, Professor.class);

        log.info("professor : {}", professor);

        // 저장
        professorRepository.save(professor);
    }

    /*public String generateProfessorId(ProfessorDTO professorDTO){
        // 연도 2자리 구하기
        String yy = "25";

        // 학과 번호 구하기
        String dept = professorDTO.getP_spec2();
        
        // 순서 번호 구하기
        int count = professorRepository.countProfessorByP_spec2();


        return yy+dept+count;
    }*/

    public String generateProfessorId(ProfessorDTO professorDTO){
        // 연도 2자리 구하기
        String yy = "25";

        // 학과 번호 구하기
        String dept = "22";

        // 순서 번호 구하기
        String count = "13";


        return yy+dept+count;
    }

}

