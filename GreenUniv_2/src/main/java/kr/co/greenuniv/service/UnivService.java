package kr.co.greenuniv.service;

import kr.co.greenuniv.dto.UnivDTO;
import kr.co.greenuniv.entity.University;
import kr.co.greenuniv.repository.UnivRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UnivService {

    private final UnivRepository univRepository;
    private final ModelMapper modelMapper;

    public void register(UnivDTO univDTO) {

        University univ = modelMapper.map(univDTO, University.class);
        log.info("univ {}", univ);
        univRepository.save(univ);
    }

    public List<University> findAll() {
        return univRepository.findAll();
    }
}
