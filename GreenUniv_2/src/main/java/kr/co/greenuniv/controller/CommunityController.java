package kr.co.greenuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityController {


    @GetMapping("/community/freeBoardWrite")
    public String CommunityController() {
        return "/community/freeBoardWrite";
    }

    @GetMapping("/community/community_announcement")
    public String community_announcement(){

        return "/community/community_announcement";
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
}
