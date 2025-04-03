package kr.co.greenuniv.service;

import kr.co.greenuniv.dto.TermsDTO;
import kr.co.greenuniv.entity.Terms;
import kr.co.greenuniv.repository.TermsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TermsService { // ✅ 클래스명 수정

    private final TermsRepository termsRepository;
    private final ModelMapper modelMapper;

    // 특정 ID로 약관을 가져오는 메서드 추가
    public TermsDTO getTermsById(int id) {
        Optional<Terms> optTerms = termsRepository.findById(id);
        return optTerms.map(terms -> modelMapper.map(terms, TermsDTO.class)).orElse(null);
    }
}
