package com.example.ecommerce.servlets.product;


import com.example.ecommerce.entity.Category;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repo.CategoryRepository;
import com.example.ecommerce.repo.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;


@MultipartConfig
@WebServlet(value = "/product/add")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String categoryId = req.getParameter("categoryId");
        Part photo = req.getPart("photo");
        Category category = CategoryRepository.findById(Integer.valueOf(categoryId));
        ProductRepository.save(
                Product.builder()
                        .name(name)
                        .price(Integer.parseInt(price))
                        .category(category)
                        .photo(photo.getInputStream().readAllBytes())
                        .build()
        );
        resp.sendRedirect("/admin/product.jsp");
    }
}
