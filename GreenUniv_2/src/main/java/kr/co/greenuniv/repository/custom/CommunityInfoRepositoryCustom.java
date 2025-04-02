package kr.co.greenuniv.repository.custom;

import com.querydsl.core.Tuple;
import kr.co.greenuniv.dto.PageRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommunityInfoRepositoryCustom {

    public Page<Tuple> selectAllForList(Pageable pageable);
    public Page<Tuple> selectAllForSearch(PageRequestDTO pageRequestDTO, Pageable pageable); // 글 목록 검색 메서드

}
