package com.example.ecommerce.servlets.authenticate;


import com.example.ecommerce.entity.User;
import com.example.ecommerce.repo.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(value = "/auth/signIn")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        User user = UserRepository.getUserByPhoneAndPassword(phone, password);
        if (user == null) {
            resp.sendRedirect("/auth/signIn.jsp");
            return;
        }
        HttpSession session = req.getSession();
        if (session.getAttribute("generateOrder") != null) {
            resp.sendRedirect("/order/add");
            session.setAttribute("id", user.getId());
            return;
        }
        session.setAttribute("id", user.getId());
        resp.sendRedirect("/home/home.jsp");
    }
}
