package com.inflearn.inflearnjpause.service;

import com.inflearn.inflearnjpause.domain.Member;
import com.inflearn.inflearnjpause.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    // 회원 가입
    public Long join(Member member){
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        List<Member> sameNameMembers = memberRepository.findByName(member.getName());
        if (!sameNameMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    // 회원 전체 조회
    // 읽기 전용일 경우 이 annotation 을 사용한다.
    // 속도 최적화
    @Transactional(readOnly = true)
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 회원 단일 조회
    @Transactional(readOnly = true)
    public Member findMember(Long id){
        return memberRepository.findOne(id);
    }

}
