package com.inflearn.inflearnjpabasic;

import com.inflearn.inflearnjpabasic.domain.Member;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;

@SpringBootApplication
public class InflearnjpabasicApplication {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        Member member = new Member();
        em.persist(member);

        SpringApplication.run(InflearnjpabasicApplication.class, args);
    }
}
