package com.inflearn.inflearnjpabasic;

import com.inflearn.inflearnjpabasic.domain.Embedable;
import com.inflearn.inflearnjpabasic.domain.Embedable2;
import com.inflearn.inflearnjpabasic.domain.EntityChild;
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
            //EntityChild entityChild = new EntityChild();

            //em.persist(entityChild);
            //em.flush();

            EntityChild entityChild = em.find(EntityChild.class, 1L);

            Parent parent = new Parent();
            parent.setEmbedable(new Embedable("jack", new Embedable2("shit", entityChild)));

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
