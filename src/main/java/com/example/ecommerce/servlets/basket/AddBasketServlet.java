package com.example.ecommerce.servlets.basket;

import com.example.ecommerce.entity.Basket;
import com.example.ecommerce.entity.BasketProduct;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(value = "/basket/add")
public class AddBasketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("productId");
        HttpSession session = req.getSession();
        if (session.getAttribute("Basket") != null) {
            Basket basket = new Basket((Basket) session.getAttribute("Basket"));
            basket.basketProducts.add(
                    new BasketProduct(
                            Integer.parseInt(productId),
                            1
                    )
            );
            session.setAttribute("Basket", basket);
        }
        resp.sendRedirect("/home/home.jsp");
    }
}
