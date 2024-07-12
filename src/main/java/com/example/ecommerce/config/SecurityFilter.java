package com.example.ecommerce.config;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebFilter("/*")
public class SecurityFilter implements Filter {

    List<String> openPages = new ArrayList<>(
            List.of(
                    "/home/home.jsp",
                    "/",
                    "/static/bootstrap.min.css",
                    "/home/basket.jsp",
                    "/auth/Auth.jsp",
                    "/auth/signIn.jsp",
                    "/auth/signUp.jsp",
                    "/basket/add",
                    "/basket/update",
                    "/auth/signIn",
                    "/auth/signUp"
            )
    );


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var request = (HttpServletRequest) servletRequest;
        var response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        if (openPages.contains(requestURI)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        HttpSession session = request.getSession();
        Object id = session.getAttribute("id");
        if (id == null) {
            response.sendRedirect("/auth/Auth.jsp");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
