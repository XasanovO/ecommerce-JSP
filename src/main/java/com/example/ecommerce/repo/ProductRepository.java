package com.example.ecommerce.repo;

import com.example.ecommerce.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;

import static com.example.ecommerce.config.MyListener.emf;


public class ProductRepository {
    public static Product findById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Product product = entityManager.find(Product.class, id);
            transaction.commit();
            return product;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return null;
    }

    public static void save(Product product) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public static List<Product> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            List<Product> products = entityManager.createQuery("from Product t", Product.class).getResultList();
            transaction.commit();
            return products;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void update(Product product, int id) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Product updateProduct = entityManager.find(Product.class, id);
            updateProduct.setName(product.getName());
            updateProduct.setCategory(product.getCategory());
            updateProduct.setPhoto(product.getPhoto());
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
            Product product = entityManager.find(Product.class, id);
            if (product != null) {
                entityManager.remove(product);
            } else {
                System.out.println("eroor delete product");
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }


    public static List<Product> findAllByCategoryId(int id) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            List<Product> products = entityManager.createQuery("from Product t where category.id = :id", Product.class).setParameter("id", id).getResultList();
            transaction.commit();
            return products;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
