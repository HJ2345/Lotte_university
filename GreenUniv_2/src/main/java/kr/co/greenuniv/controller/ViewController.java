package kr.co.greenuniv.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.greenuniv.dto.CommunityInfoDTO;
import kr.co.greenuniv.service.CommunityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Slf4j
@Controller
public class ViewController {

    private final CommunityService communityService;

    @GetMapping("/community/CommunityView")
    public String view(int no, HttpServletRequest request, Model model) {

        // 글 조회 서비스 호출
        CommunityInfoDTO communityInfoDTO = communityService.findById(no);

        model.addAttribute(communityInfoDTO);
        return "/community/CommunityView";
    }


}
