package com.inflearn.inflearnjpabasic;

import com.inflearn.inflearnjpabasic.domain.Member;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import java.util.List;

@SpringBootApplication
public class InflearnjpabasicApplication {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Member member = new Member();
        em.persist(member);
        List<Member> result =  em.createQuery("select m from Member", Member.class)
                .setFirstResult(5)
                .setMaxResults(8)
                .getResultList();

        SpringApplication.run(InflearnjpabasicApplication.class, args);
    }
}
