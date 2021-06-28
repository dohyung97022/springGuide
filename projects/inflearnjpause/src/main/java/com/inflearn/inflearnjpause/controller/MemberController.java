package com.inflearn.inflearnjpause.controller;

import com.inflearn.inflearnjpause.repository.MemberRepository;
import com.inflearn.inflearnjpause.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","김도형");
        return "hello";
    }
}
