package com.inflearn.inflearnjpause.repository;

import com.inflearn.inflearnjpause.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepositoryy extends JpaRepository<Member, Long> {
}
