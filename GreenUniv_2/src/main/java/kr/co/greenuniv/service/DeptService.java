package kr.co.greenuniv.service;

import kr.co.greenuniv.dto.DeptDTO;
import kr.co.greenuniv.entity.Department;
import kr.co.greenuniv.entity.University;
import kr.co.greenuniv.repository.DeptRepository;
import kr.co.greenuniv.repository.UnivRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeptService {

    private final DeptRepository deptRepository;
    private final UnivRepository univRepository;
    private final ModelMapper modelMapper;

    public void register(DeptDTO deptDTO) {
        // 학과 엔티티 변환
        Department dept = modelMapper.map(deptDTO, Department.class);

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
}
