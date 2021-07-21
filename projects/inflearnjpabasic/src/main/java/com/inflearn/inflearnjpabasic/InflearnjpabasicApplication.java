package com.inflearn.inflearnjpabasic;

import com.inflearn.inflearnjpabasic.domain.Child;
import com.inflearn.inflearnjpabasic.domain.Parent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;

@SpringBootApplication
public class InflearnjpabasicApplication {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Parent parent = new Parent();

            parent.setName("hello");
            parent.addChild(new Child("김도형"));

            em.persist(parent);
            em.flush();
            em.clear();

            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            em.close();
        }

        SpringApplication.run(InflearnjpabasicApplication.class, args);
    }
}
