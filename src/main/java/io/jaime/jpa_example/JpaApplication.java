package io.jaime.jpa_example;

import io.jaime.jpa_example.domain.model.entity.Player;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaApplication {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            executeTransaction(entityManager);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    private static void executeTransaction(EntityManager entityManager) {
        Player player = new Player();
        player.setId("id");
        player.setName("Lionel Messi");
        player.setGoal(50);
        player.setAssist(25);
        System.out.println(player);

        entityManager.persist(player);

        player.setAssist(26);

        Player messi = entityManager.find(Player.class, "id");
        System.out.println(messi);

        List<Player> players = entityManager.createQuery("select player from Player player", Player.class).getResultList();
        System.out.println(players);

        entityManager.remove(player);
    }
}
