package com.example.ecommerce.repo;

import com.example.ecommerce.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;

import static com.example.ecommerce.config.MyListener.emf;


public class UserRepository {
    public static int save(User user) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
            return user.getId();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        throw new RuntimeException("error save user !");
    }

    public static User getUserByPhoneAndPassword(String phone, String password) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User user = entityManager.createQuery("from User t where phone = :phone and password = :password", User.class)
                    .setParameter("phone", phone)
                    .setParameter("password", password)
                    .getSingleResult();
            transaction.commit();
            return user;
        } catch (NoResultException e) {
            System.out.println("No user found for phone: " + phone);
        } catch (NonUniqueResultException e) {
            System.out.println("Multiple users found for phone: " + phone);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    public static User findById(int userId) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User user = entityManager.find(User.class, userId);
            transaction.commit();
            return user;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        throw new RuntimeException("error find user !");
    }
}
