import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ArrayList<String> ListArr = new ArrayList<>();
        ListArr.add("hello");
        ListArr.add("hello");

        Employe johnDoe = new Employe();
        johnDoe.setName("jkljùe");
        johnDoe.setEmail("ama@gmail.com");
        johnDoe.setSkills(ListArr);

        entityManager.persist(johnDoe);


        Employe willDoe = new Employe();
        willDoe.setName("jkljùe");
        willDoe.setEmail("ama@gmail.com");
        willDoe.setSkills(ListArr);
        entityManager.persist(willDoe);




        entityManager.getTransaction().commit();
        entityManager.clear();

        entityManager.close();
    }
}
