package com.example.ecommerce.servlets.category;


import com.example.ecommerce.entity.Category;
import com.example.ecommerce.repo.CategoryRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(value = "/category/add")
public class AddCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        CategoryRepository.save(Category.builder().name(name).build());
        resp.sendRedirect("/admin/category.jsp");
    }
}
