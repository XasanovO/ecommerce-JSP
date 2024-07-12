package com.example.ecommerce.servlets.category;

import com.example.ecommerce.entity.Category;
import com.example.ecommerce.repo.CategoryRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(value = "/category/update")
public class UpdateCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int id = Integer.parseInt(req.getParameter("id"));
        CategoryRepository.update(Category.builder().name(name).build(), id);
        resp.sendRedirect("/admin/category.jsp");
    }
}
