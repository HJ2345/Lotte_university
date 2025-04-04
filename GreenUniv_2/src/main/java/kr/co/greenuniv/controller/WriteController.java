package kr.co.greenuniv.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.greenuniv.dto.CommunityInfoDTO;
import kr.co.greenuniv.service.CommunityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Slf4j
@Controller
public class WriteController {

    private final CommunityService communityService;

    @GetMapping("/community/CommunityWrite")
    public String write() {
        return "/community/CommunityWrite";
    }

    @PostMapping("/community/CommunityWrite")
    public String write(CommunityInfoDTO communityInfoDTO, HttpServletRequest request) {

        //communityService.

        System.out.println(communityInfoDTO);
        System.out.println(communityInfoDTO);
        System.out.println(communityInfoDTO);
        System.out.println(communityInfoDTO);

        String regip = request.getRemoteAddr();
        communityInfoDTO.setRegip(regip);
        log.info("communityInfoDTO: {}", communityInfoDTO);

        // 파일 업로드 서비스 호출
//        List<FileDTO> files = fileService.uploadFile(communityInfoDTO);

        // 글 저장 서비스 호출
//        communityInfoDTO.setFile(files.size()); // 업로드 된 파일 갯수
        communityService.register(communityInfoDTO);

//        int no = communityInfoDTO.getCinforId();
//
//        // 파일 저장 서비스 호출
//        for(FileDTO fileDTO : files) {
//            fileDTO.setAno(no);
//            fileService.save(fileDTO);
//        }

        // 리다이렉트
        return "redirect:/community/CommunityInfo";
    }


}
