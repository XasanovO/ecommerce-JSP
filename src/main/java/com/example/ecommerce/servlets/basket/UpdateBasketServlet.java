package com.example.ecommerce.servlets.basket;

import com.example.ecommerce.entity.Basket;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(value = "/basket/update")
public class UpdateBasketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String basketProductId = req.getParameter("id");
        HttpSession session = req.getSession();
        if (session.getAttribute("Basket") != null) {
            String opt = req.getParameter("opt");
            Basket basket = new Basket((Basket) session.getAttribute("Basket"));
            if (opt.equals("-")) {
                basket.decrementBasketProductById(basketProductId);
            } else {
                basket.incrementBasketProductById(basketProductId);
            }
            session.setAttribute("Basket", basket);
        }
        resp.sendRedirect("/home/basket.jsp");
    }
}
