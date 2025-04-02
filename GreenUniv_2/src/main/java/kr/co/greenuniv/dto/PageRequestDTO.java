package kr.co.greenuniv.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageRequestDTO {

    @Builder.Default // 초기화
    private int no = 1;

    @Builder.Default
    private String cate = "free";

    @Builder.Default
    private int pg = 1;

    @Builder.Default
    private int size = 10;

    private String searchType;
    private String keyword;

    // 글 목록 페이징 처리를 위한 Pageable 객체 생성 메서드
    public Pageable getPageable(String sort) { // sort 정렬 문자열, Pageable로 페이징 처리
        return PageRequest.of(this.pg - 1, this.size, Sort.by(sort).descending());
    }

}
