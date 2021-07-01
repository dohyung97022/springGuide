package com.example.inflearnrecap.controller;

import com.example.inflearnrecap.domain.Member;
import com.example.inflearnrecap.domain.MemberDto;
import com.example.inflearnrecap.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {

    @Autowired
    private final MemberRepository memberRepository;

    @PostMapping("/members")
    public Long createMember(@RequestBody MemberDto memberDto){
        Member member = new Member(memberDto);
        return memberRepository.save(member).getId();
    }
}
