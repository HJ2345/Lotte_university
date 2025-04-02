package kr.co.greenuniv.repository;

import com.querydsl.core.Tuple;
import kr.co.greenuniv.dto.PageRequestDTO;
import kr.co.greenuniv.entity.CommunityInfo;
import kr.co.greenuniv.repository.custom.CommunityInfoRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityInfoRepository extends JpaRepository<CommunityInfo, Integer>, CommunityInfoRepositoryCustom {
}
