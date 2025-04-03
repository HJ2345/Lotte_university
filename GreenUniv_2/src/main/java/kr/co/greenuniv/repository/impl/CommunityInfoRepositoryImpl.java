package kr.co.greenuniv.repository.impl;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.greenuniv.dto.PageRequestDTO;
import kr.co.greenuniv.entity.QCommunityInfo;
import kr.co.greenuniv.entity.QUser;
import kr.co.greenuniv.repository.custom.CommunityInfoRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CommunityInfoRepositoryImpl implements CommunityInfoRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private QCommunityInfo qCommunityInfo = QCommunityInfo.communityInfo;
    private QUser qUser = QUser.user;

    @Override
    public Page<Tuple> selectAllForList(Pageable pageable) {

        // select~ from~ join~ on~ limit 0,10(첫번째 값 offset, 두번째 값 size) orderby~
        List<Tuple> tupleList = queryFactory // 페이징 된 리스트
                                        .select(qCommunityInfo, qUser.uid)
                                        .from(qCommunityInfo)
                                        .join(qUser)
                                        .on(qCommunityInfo.user.uid.eq(qUser.uid))
                                        .offset(pageable.getOffset())
                                        .limit(pageable.getPageSize())
                                        .orderBy(qCommunityInfo.CinforId.desc())
                                        .fetch();

        long total = queryFactory.select(qCommunityInfo.count()).from(qCommunityInfo).fetchOne();

        log.info(tupleList.toString());

        // 페이징 처리를 위한 페이지 객체 반환
        return new PageImpl<Tuple>(tupleList, pageable, total);
    }

    // 글 목록 검색 메서드
    @Override
    public Page<Tuple> selectAllForSearch(PageRequestDTO pageRequestDTO, Pageable pageable) {

        String searchType = pageRequestDTO.getSearchType();
        String keyword = pageRequestDTO.getKeyword();

        // 검색 조건에 따라서 where 조건 표현식 생성
        BooleanExpression expression = null;

        if(searchType.equals("title")){ // 제목 검색
            expression = qCommunityInfo.title.contains(keyword); // where title = contain 'keyword'
        }else if(searchType.equals("content")){
            expression = qCommunityInfo.content.contains(keyword);
        }else if(searchType.equals("writer")){
            expression = qUser.name.contains(keyword);
        }

        List<Tuple> tupleList = queryFactory // 페이징 된 리스트
                .select(qCommunityInfo, qUser.name)
                .from(qCommunityInfo)
                .join(qUser)
                .on(qCommunityInfo.user.uid.eq(qUser.uid))
                .where(expression)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(qCommunityInfo.CinforId.desc())
                .fetch();

        long total = queryFactory
                            .select(qCommunityInfo.count())
                            .from(qCommunityInfo)
                            .join(qUser)
                            .on(qCommunityInfo.user.uid.eq(qUser.uid))
                            .where(expression)
                            .fetchOne();

        // 페이징 처리를 위한 페이지 객체 반환
        return new PageImpl<Tuple>(tupleList, pageable, total);
    }
}
