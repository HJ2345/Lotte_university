package kr.co.greenuniv.service;

import kr.co.greenuniv.dto.CommunityInfoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommunityServiceTest {

    @Autowired
    private CommunityService communityService;

    @Test
    void register() {
        //communityInfoDTO: CommunityInfoDTO(CinforId=0, title=fdg, content=0, writer=a1234, company=null, hit=0, status=0, deadline=null, wdate=null, nick=null, regip=0:0:0:0:0:0:0:1)
        CommunityInfoDTO communityInfoDTO = CommunityInfoDTO.builder()
                .title("제목1")
                .content("내용1")
                .writer("a1234")
                .regip("0:0:0:0:0:0:0:1")
                .build();

        int value = communityService.register(communityInfoDTO);

        System.out.println(value);
    }
}