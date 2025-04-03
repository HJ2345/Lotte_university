package kr.co.greenuniv.service;

import kr.co.greenuniv.dto.GradDTO;
import kr.co.greenuniv.repository.GradRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GradService {
    public List<GradDTO> findAll(){
        return GradRepository.findByunivname();
    }
}
