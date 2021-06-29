package com.inflearn.inflearnjpause.service;

import com.inflearn.inflearnjpause.domain.Member;
import com.inflearn.inflearnjpause.repository.MemberRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void register() throws Exception{
        Member member = new Member();
        member.setName("김도형");
        Long savedId = memberService.join(member);
        Assertions.assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void sameAccountException() throws Exception{
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        memberService.join(member1);
        try{
            memberService.join(member1);
        }catch (IllegalStateException e){
            return;
        }
        throw new Exception("예외가 발생해야 한다.");
    }
}