package kr.co.greenuniv.service;

import kr.co.greenuniv.dto.DeptDTO;
import kr.co.greenuniv.entity.Department;
import kr.co.greenuniv.entity.University;
import kr.co.greenuniv.repository.DeptRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeptService {

    private final DeptRepository deptRepository;
    private final ModelMapper modelMapper;

    public void register(DeptDTO deptDTO) {
        Department dept = modelMapper.map(deptDTO, Department.class);
        deptRepository.save(dept);
    }
}
