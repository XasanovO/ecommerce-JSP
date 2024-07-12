package com.example.ecommerce.servlets.order;


import com.example.ecommerce.entity.*;
import com.example.ecommerce.repo.OrderProductRepository;
import com.example.ecommerce.repo.OrderRepository;
import com.example.ecommerce.repo.ProductRepository;
import com.example.ecommerce.repo.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;


@WebServlet(value = "/order/add")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("id") != null) {
            int userId = (int) session.getAttribute("id");
            User user = UserRepository.findById(userId);
            if (session.getAttribute("Basket") != null) {
                Basket basket = new Basket((Basket) session.getAttribute("Basket"));
                Order order = OrderRepository.save(Order
                        .builder()
                        .dateTime(LocalDateTime.now())
                        .user(user)
                        .build()
                );
                for (BasketProduct basketProduct : basket.basketProducts) {
                    Product product = ProductRepository.findById(basketProduct.getProductId());
                    OrderProductRepository.save(
                            OrderProduct
                                    .builder()
                                    .order(order)
                                    .product(product)
                                    .amount(basketProduct.getAmount())
                                    .build()
                    );
                }
                basket.basketProducts.clear();
                session.setAttribute("Basket", basket);
            }
        }
        resp.sendRedirect("/home/home.jsp");
    }
}
