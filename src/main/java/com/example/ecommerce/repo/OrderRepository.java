package com.example.ecommerce.repo;

import com.example.ecommerce.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import static com.example.ecommerce.config.MyListener.emf;


public class OrderRepository {
    public static Order save(Order order) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(order);
            transaction.commit();
            return order;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("error save order !!!");
    }
}
