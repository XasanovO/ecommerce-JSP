package com.example.ecommerce.repo;

import com.example.ecommerce.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

import static com.example.ecommerce.config.MyListener.emf;


public class CategoryRepository {

    public static Category findById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Category category = entityManager.find(Category.class, id);
            transaction.commit();
            return category;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return null;
    }

    public static void save(Category category) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(category);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public static List<Category> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        try {
            List<Category> categories = entityManager.createQuery("from Category t", Category.class).getResultList();
            return categories;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void update(Category category, int id) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Category updateCategory = entityManager.find(Category.class, id);
            updateCategory.setName(category.getName());
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Category category = entityManager.find(Category.class, id); // Fetching within the same transactional context
            if (category != null) {
                entityManager.remove(category);
            } else {
                System.out.println("Category with id " + id + " not found.");
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
