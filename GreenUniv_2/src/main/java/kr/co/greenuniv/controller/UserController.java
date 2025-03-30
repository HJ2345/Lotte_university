package kr.co.greenuniv.controller;

import jakarta.servlet.http.HttpServletRequest;
//import kr.co.greenuniv.dto.TermsDTO;
import kr.co.greenuniv.dto.UserDTO;
//import kr.co.greenuniv.service.TermsService;
import kr.co.greenuniv.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
@Controller
public class UserController {

    //private final TermsService termsService;
    private final UserService userService;


    @GetMapping("/login")
    public String login(){
        return "/user/login";
    }

    @GetMapping("/register")
    public String register(){
        return "/user/register";
    }

    @PostMapping("/register")
    public String register(HttpServletRequest req, UserDTO userDTO){

        String regip = req.getRemoteAddr();
        userDTO.setRegip(regip);

        // 서비스 호출
        userService.register(userDTO);

        // 리다이렉트
        return "redirect:/user/login";
    }
    @GetMapping("/terms")
    public String terms() {
        return "user/terms";
    }

}
