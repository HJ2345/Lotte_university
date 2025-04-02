package kr.co.greenuniv.controller;

import kr.co.greenuniv.dto.CommunityInfoDTO;
import kr.co.greenuniv.dto.PageRequestDTO;
import kr.co.greenuniv.dto.PageResponseDTO;
import kr.co.greenuniv.service.CommunityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping("/community/CommunityInfo")
    public String CommunityInfo(Model model, PageRequestDTO pageRequestDTO) {

        // 전체 글 조회 서비스 호출(JPA)
        PageResponseDTO pageResponseDTO = communityService.findAll(pageRequestDTO);

        // 전체 글 조회 서비스 호출(Mybatis)
        model.addAttribute(pageResponseDTO);
        log.info(pageResponseDTO.toString());

        return "/community/CommunityInfo";
    }

    @GetMapping("/community/Einformation")
    public String Einformation(){
        return "/community/Einformation";
    }

    @GetMapping("/community/Fboard")
    public String Fboard(){
        return "/community/Fboard";
    }

    @GetMapping("/community/news")
    public String news(){
        return "/community/news";
    }

    @GetMapping("/community/qna")
    public String qna(){
        return "/community/qna";
    }

    @GetMapping("/community/reference")
    public String reference(){
        return "/community/reference";
    }

    @GetMapping("/community/newsView")
    public String newsView() {
        return "/community/newsView";
    }
}
