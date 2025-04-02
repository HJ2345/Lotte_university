package kr.co.greenuniv.dao;

import kr.co.greenuniv.dto.CommunityInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityInfoMapper {

    // Mybatis가 INSERT한 데이터의 PK값을 매개변수 DTO의 해당 속성으로 반환
    public void insertArticle(CommunityInfoDTO communityInfoDTO);

}
