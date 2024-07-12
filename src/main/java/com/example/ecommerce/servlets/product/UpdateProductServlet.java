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
@WebServlet(value = "/product/update")
public class UpdateProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String productId = req.getParameter("id");
        String price = req.getParameter("price");
        String categoryId = req.getParameter("categoryId");
        Part photo = req.getPart("photo");
        Category category = CategoryRepository.findById(Integer.valueOf(categoryId));
        Product product = null;
        if (photo.getInputStream().readAllBytes().length == 0) {
            product = ProductRepository.findById(Integer.parseInt(productId));
        }
        ProductRepository.update(
                Product
                        .builder()
                        .name(name)
                        .category(category)
                        .price(Integer.parseInt(price))
                        .photo(product != null ? product.getPhoto() : photo.getInputStream().readAllBytes())
                        .build(),
                Integer.parseInt(productId)
        );
        resp.sendRedirect("/admin/product.jsp");
    }
}
