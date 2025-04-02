package kr.co.greenuniv.service;

import com.querydsl.core.Tuple;
import kr.co.greenuniv.dao.CommunityInfoMapper;
import kr.co.greenuniv.dto.CommunityInfoDTO;
import kr.co.greenuniv.dto.PageRequestDTO;
import kr.co.greenuniv.dto.PageResponseDTO;
import kr.co.greenuniv.entity.CommunityInfo;
import kr.co.greenuniv.repository.CommunityInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class CommunityService {

    private final CommunityInfoRepository communityInfoRepository;
    private final ModelMapper modelMapper;

    // 글 목록 검색
    public PageResponseDTO searchAll(PageRequestDTO pageRequestDTO) {

        // 페이징 처리를 위한 pageable 객체 생성
        Pageable pageable = pageRequestDTO.getPageable("no"); // 최신글부터 정렬, 내림차순

        Page<Tuple> pageCommunityInfo = communityInfoRepository.selectAllForSearch(pageRequestDTO, pageable);

        log.info("pageCommunityInfo : {} ", pageCommunityInfo);

        // Article Entity 리스트를 ArticleDTO 리스트로 변환
        List<CommunityInfoDTO> communityInfoDTOList = pageCommunityInfo.getContent().stream().map(tuple -> { // 아티클 엔티티를 아티클DTO로 변환

            CommunityInfo communityInfo = tuple.get(0, CommunityInfo.class); // .select(qArticle, qUser.nick) 1번째 값
            String nick = tuple.get(1, String.class); // .select(qArticle, qUser.nick) 2번째 값

            CommunityInfoDTO communityInfoDTO = modelMapper.map(communityInfo, CommunityInfoDTO.class);
            communityInfoDTO.setNick(nick);

            return communityInfoDTO;

        }).toList();

        // 전체 게시물 갯수
        int total = (int) pageCommunityInfo.getTotalElements();

        return PageResponseDTO
                .builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(communityInfoDTOList)
                .total(total)
                .build();
    }

    // 글 목록 조회
    public PageResponseDTO findAll(PageRequestDTO pageRequestDTO) {

        // 페이징 처리를 위한 pageable 객체 생성
        Pageable pageable = pageRequestDTO.getPageable("no"); // 최신글부터 정렬, 내림차순

        Page<Tuple> pageArticle = communityInfoRepository.selectAllForList(pageable);

        log.info("pageArticle : {} ", pageArticle);

        // Article Entity 리스트를 ArticleDTO 리스트로 변환
        List<CommunityInfoDTO> communityInfoDTOList = pageArticle.getContent().stream().map(tuple -> { // 아티클 엔티티를 아티클DTO로 변환

            CommunityInfo communityInfo = tuple.get(0, CommunityInfo.class); // .select(qArticle, qUser.nick) 1번째 값
            String nick = tuple.get(1, String.class); // .select(qArticle, qUser.nick) 2번째 값

            CommunityInfoDTO communityInfoDTO = modelMapper.map(communityInfo, CommunityInfoDTO.class);
            communityInfoDTO.setNick(nick);

            return communityInfoDTO;

        }).toList();

        // 전체 게시물 갯수
        int total = (int) pageArticle.getTotalElements();

        return PageResponseDTO
                .builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(communityInfoDTOList)
                .total(total)
                .build();
    }

    // 글 클릭 시 뷰
    public CommunityInfoDTO findById(int no) {

        Optional<CommunityInfo> optArticle = communityInfoRepository.findById(no);

        if (optArticle.isPresent()) {
            CommunityInfo article = optArticle.get();
            CommunityInfoDTO communityInfoDTO = modelMapper.map(article, CommunityInfoDTO.class);
            return communityInfoDTO; // 유저 정보, 파일 정보

        }

        return null;

    }
}
