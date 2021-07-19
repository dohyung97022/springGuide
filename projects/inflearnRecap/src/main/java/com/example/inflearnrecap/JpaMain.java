package com.example.inflearnrecap;

import com.example.inflearnrecap.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            // insert 문
            Member member = new Member("김도형","서울","영동대로","201958");
            em.persist(member);
            
            em.flush();
            em.clear();


            Member findMember = em.getReference(Member.class, member.getId());
            String name = findMember.getName();
            // Member findMember = em.find(Member.class, member.getId());

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
