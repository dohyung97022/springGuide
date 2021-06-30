package com.inflearn.inflearnjpause.repository;

import com.inflearn.inflearnjpause.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public Long save(Member member) {
        entityManager.persist(member);
        return member.getId();
    }

    public Member findOne(Long id) {
        return entityManager.find(Member.class, id);
    }
}
