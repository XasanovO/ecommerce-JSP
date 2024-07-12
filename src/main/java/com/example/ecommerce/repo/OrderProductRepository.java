package com.example.ecommerce.repo;

import com.example.ecommerce.entity.OrderProduct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import static com.example.ecommerce.config.MyListener.emf;


public class OrderProductRepository {
    public static void save(OrderProduct orderProduct) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(orderProduct);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
