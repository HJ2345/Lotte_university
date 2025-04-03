package kr.co.greenuniv.controller;

import kr.co.greenuniv.entity.Terms;
import jakarta.servlet.http.HttpServletRequest;
import kr.co.greenuniv.dto.TermsDTO;
import jakarta.servlet.http.HttpSession;
import kr.co.greenuniv.dto.UserDTO;
import kr.co.greenuniv.service.TermsService;
import kr.co.greenuniv.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
@Controller
public class UserController {

    private final TermsService termsService;
    private final UserService userService;

    // 로그인 페이지
    @GetMapping("/login")
    public String login() {
        return "/user/login";
    }

    // 회원가입 페이지
    @GetMapping("/register")
    public String register() {
        return "/user/register";
    }

    @PostMapping("/register")
    public String register(HttpServletRequest req, UserDTO userDTO) {
        String regip = req.getRemoteAddr();
        userDTO.setRegip(regip);

        log.info("userDTO: {}", userDTO);

        userService.register(userDTO);
        return "redirect:/user/login";
    }

    // 약관 페이지
    @GetMapping("/terms")
    public String getTerms(Model model) {
        TermsDTO termsDTO = termsService.getTermsById(1); // ✅ TermsDTO로 받기

        if (termsDTO != null) {
            model.addAttribute("terms", termsDTO.getTerms());
            model.addAttribute("privacy", termsDTO.getPrivacy());
        } else {
            model.addAttribute("terms", "약관을 불러올 수 없습니다.");
            model.addAttribute("privacy", "개인정보 처리방침을 불러올 수 없습니다.");
        }

        return "/user/terms";
    }


    // 이메일 중복 체크
    @GetMapping("/email/{email}")
    public ResponseEntity checkEmail(@PathVariable("email") String email) {
        long count = userService.checkUser("email", email);
        Map<String, Long> result = new HashMap<>();
        result.put("count", count);
        return ResponseEntity.ok(result);
    }

    // 동적 타입 체크
    @GetMapping("/{type}/{value}")
    public ResponseEntity user(@PathVariable("type") String type, @PathVariable("value") String value) {
        log.info("type : " + type + ", value : " + value);
        long count = userService.checkUser(type, value);
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("count", count);
        return ResponseEntity.ok().body(resultMap);
    }

    // 이메일 인증 코드 확인
    @PostMapping("/email/auth")
    public ResponseEntity<Boolean> emailAuth(@RequestBody Map<String, String> map, HttpSession session) {
        String authCode = map.get("authCode");
        log.info("authCode : {}", authCode);
        String sessAuthCode = (String) session.getAttribute("authCode");
        log.info("sessAuthCode : {}", sessAuthCode);

        if (authCode.equals(sessAuthCode)) {
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
}