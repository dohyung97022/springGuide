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

        tx.begin();

        try{
            Member member = em.find(Member.class, 1L);
            member.setName("hello");
            em.persist(member);
            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        SpringApplication.run(InflearnjpabasicApplication.class, args);
    }

    private static void printMemberAndTeam(Member member){
        String username = member.getName();
        System.out.println("username = " + username);
    }
}
