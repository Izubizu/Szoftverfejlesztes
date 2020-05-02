package book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        try {
            for(int i=0; i<1000; i++) {
                em.getTransaction().begin();
                em.persist(BookGenerator.createBook());
                em.getTransaction().commit();
                System.out.println(BookGenerator.createBook());
            }
        } finally {
            em.close();
        }
    }
}


