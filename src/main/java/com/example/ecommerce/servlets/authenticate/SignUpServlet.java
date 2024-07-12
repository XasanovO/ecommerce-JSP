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


@WebServlet(value = "/auth/signUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int userId = UserRepository.save(
                User.builder()
                        .email(email)
                        .password(password)
                        .phone(phone)
                        .username(username)
                        .build());
        HttpSession session = req.getSession();
        session.setAttribute("id", userId);
        if (session.getAttribute("generateOrder") != null) {
            resp.sendRedirect("/order/add");
            session.setAttribute("id", userId);
            return;
        }
        resp.sendRedirect("/home/home.jsp");
    }
}
